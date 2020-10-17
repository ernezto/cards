package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.DeckBuilder;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository repository;

    public Game create(Game game) {
        return repository.save(game);
    }

    public void delete(int gameId) {
        repository.delete(gameId);
    }
}
