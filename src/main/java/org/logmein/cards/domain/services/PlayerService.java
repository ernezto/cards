package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public Player create(Player player) {
        return repository.save(player);
    }
}
