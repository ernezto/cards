package org.logmein.cards.web.validations.deck;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.web.validations.CustomConstraintValidator;

import java.util.Optional;

@AllArgsConstructor
public class DeckIdExistsValidator extends CustomConstraintValidator<DeckIdExists, Integer> {
    private final DeckRepository repository;

    @Override
    public boolean validate(Integer deckId) {
        Optional<Deck> optionalDeck = repository.find(deckId);
        return optionalDeck.isPresent();
    }
}
