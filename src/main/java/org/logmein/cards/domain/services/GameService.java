package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final DeckRepository deckRepository;
    private final PlayerRepository playerRepository;

    public Game create(Game game) {
        return gameRepository.save(game);
    }

    public void delete(int gameId) {
        gameRepository.delete(gameId);
    }

    public Game addDeckToGame(Integer gameId, Integer deckId) {
        final Game game = gameRepository.get(gameId);
        final Deck deck = deckRepository.get(deckId);
        game.addDeck(deck);
        return gameRepository.save(game);
    }

    public Game addPlayerToGame(Integer gameId, Integer playerId) {
        final Game game = gameRepository.get(gameId);
        final Player player = playerRepository.get(playerId);
        game.addPlayer(player);
        return gameRepository.save(game);
    }

    public Game removePlayerFromGame(Integer gameId, Integer playerId) {
        final Game game = gameRepository.get(gameId);
        game.removePlayer(playerId);
        return gameRepository.save(game);
    }
}
