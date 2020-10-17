package org.logmein.cards.web.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public abstract class CustomConstraintValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {
    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {
        boolean isValid = validate(value);
        if ( !isValid ) {
            String messageTemplate = context.getDefaultConstraintMessageTemplate();
            context. buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation();
        }
        return isValid;
    }

    public abstract boolean validate(T value);
}
