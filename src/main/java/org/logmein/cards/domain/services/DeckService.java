package org.logmein.cards.domain.services;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.DeckBuilder;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeckService {
    private final DeckRepository repository;

    public Deck create() {
        Deck deck = DeckBuilder.classic().build();
        return repository.save(deck);
    }
}
