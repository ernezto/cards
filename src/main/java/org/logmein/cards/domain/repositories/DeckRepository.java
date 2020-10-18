package org.logmein.cards.domain.repositories;

import org.logmein.cards.domain.models.Deck;

import java.util.List;
import java.util.Optional;

public interface DeckRepository {
    Deck save(Deck deck);

    Optional<Deck> find(int id);

    boolean isDeckAssigned(Integer deckId);

    Deck get(Integer id);

    List<Deck> save(List<Deck> decks);
}
