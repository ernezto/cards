package org.logmein.cards.web.validations.deck;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.logmein.cards.web.validations.CustomConstraintValidator;

@AllArgsConstructor
public class DeckNotAssignedValidator extends CustomConstraintValidator<DeckNotAssigned, Integer> {
    private final DeckRepository repository;

    @Override
    public boolean validate(Integer deckId) {
        return !repository.isDeckAssigned(deckId);
    }
}
