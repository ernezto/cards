package org.logmein.cards.web.validations.deck;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.logmein.cards.web.validations.ValidationMessages.DECK_ALREADY_ASSIGNED;
import static org.logmein.cards.web.validations.ValidationMessages.NOT_FOUND;

@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
@Constraint(validatedBy = DeckNotAssignedValidator.class)
public @interface DeckNotAssigned {
    String message() default DECK_ALREADY_ASSIGNED;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
