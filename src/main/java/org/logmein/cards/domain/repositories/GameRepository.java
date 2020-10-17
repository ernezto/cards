package org.logmein.cards.domain.repositories;

import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Game;

public interface GameRepository {
    Game save(Game game);

    Deck find(int id);
}
