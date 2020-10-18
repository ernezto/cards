package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.mappers.PlayerToPlayerReportMapper;
import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.FaceType;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.models.reports.CardCountBySuitAndValue;
import org.logmein.cards.domain.models.reports.CardTotalBySuit;
import org.logmein.cards.domain.models.reports.PlayerHandTotal;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

@Service
@AllArgsConstructor
public class ReportService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final PlayerToPlayerReportMapper mapper;

    public List<Card> getPlayerCards(Integer playerId) {
        final Player player = playerRepository.get(playerId);
        return player.getCards();
    }

    public List<PlayerHandTotal> playersHandValueSortedDesc(Integer gameId) {
        List<Player> playersByGame = gameRepository.get(gameId).getPlayers();
        return playersByGame
                .stream()
                .map(mapper::toPlayerReport)
                .sorted(comparingInt(PlayerHandTotal::getHandTotalValue).reversed())
                .collect(toList());
    }

    public List<CardTotalBySuit> numberOfCardsBySuit(Integer gameId) {
        List<Card> undealtCards = gameRepository.get(gameId).getUndealtCards();
        return undealtCards
                .stream()
                .collect(groupingBy(Card::getSuit, counting()))
                .entrySet()
                .stream()
                .map(e -> new CardTotalBySuit(e.getKey(), e.getValue().intValue()))
                .collect(toList());
    }
    public List<CardCountBySuitAndValue> numberOfCardsBySuitAndValueSortedDesc(Integer gameId) {
        List<Card> undealtCards = gameRepository.get(gameId).getUndealtCards();
        return undealtCards
                .stream()
                .collect(groupingBy(c -> Pair.of(c.getSuit(), c.getFace()), counting()))
                .entrySet()
                .stream()
                .map(e -> new CardCountBySuitAndValue(e.getKey().getFirst(), e.getKey().getSecond(), e.getKey().getSecond().getValue(), e.getValue().intValue()))
                .sorted(comparing(CardCountBySuitAndValue::getSuit).thenComparing(CardCountBySuitAndValue::getValue).reversed())
                .collect(toList());
    }
}
