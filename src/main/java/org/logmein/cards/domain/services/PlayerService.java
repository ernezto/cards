package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public Player create(Player player) {
        return repository.save(player);
    }

    public List<Card> getPlayerCards(Integer playerId) {
        final Player player = repository.get(playerId);
        return player.getCards();
    }
}
