package org.logmein.cards.web.validations.game;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
@Constraint(validatedBy = GameIdExistsValidator.class)
public @interface GameIdExists {
    String message() default "not found";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
