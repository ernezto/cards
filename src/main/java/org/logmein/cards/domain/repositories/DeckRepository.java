package org.logmein.cards.domain.repositories;

import org.logmein.cards.domain.models.Deck;

public interface DeckRepository {
    Deck save(Deck deck);

    Deck find(int id);
}
