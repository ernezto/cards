package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.mappers.PlayerToPlayerReportMapper;
import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.models.reports.PlayerReport;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

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

    public List<PlayerReport> getPlayerHands(Integer gameId) {
        List<Player> playersByGame = gameRepository.get(gameId).getPlayers();
        return playersByGame
                .stream()
                .map(mapper::toPlayerReport)
                .sorted(comparingInt(PlayerReport::getHandTotalValue).reversed())
                .collect(toList());
    }
}
