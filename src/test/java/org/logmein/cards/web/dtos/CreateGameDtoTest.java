package org.logmein.cards.web.dtos;

import org.junit.jupiter.api.Test;
import org.logmein.cards.web.ValidationErrors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.logmein.cards.web.ValidationErrors.MUST_NOT_BE_EMPTY;

public class CreateGameDtoTest {

    @Test
    public void shouldReturnErrorWhenNameIsNotDefined() {
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final CreateGameDto emptyNameGame = new CreateGameDto();
        Set<ConstraintViolation<CreateGameDto>> violations = validator.validate(emptyNameGame);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo(MUST_NOT_BE_EMPTY);
    }
}