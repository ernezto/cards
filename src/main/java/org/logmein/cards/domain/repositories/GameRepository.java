package org.logmein.cards.domain.repositories;

import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.models.Player;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    Game save(Game game);

    Optional<Game> find(int id);

    void delete(int gameId);

    Game get(Integer id);
}
