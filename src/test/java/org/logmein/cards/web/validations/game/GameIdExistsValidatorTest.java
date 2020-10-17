package org.logmein.cards.web.validations.game;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.GameRepository;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameIdExistsValidatorTest {
    private final EasyRandom random = new EasyRandom();
    @Mock(stubOnly = true)
    private GameRepository repository;

    @Test
    public void shouldReturnFalseWhenGameIdIsNotFound() {
        final int gameId = random.nextInt();
        when(repository.find(gameId)).thenReturn(empty());
        final GameIdExistsValidator validator = new GameIdExistsValidator(repository);
        final boolean isValid = validator.validate(gameId);
        assertThat(isValid).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenGameIdIsNotFound() {
        final int gameId = random.nextInt();
        when(repository.find(gameId)).thenReturn(of(random.nextObject(Game.class)));
        final GameIdExistsValidator validator = new GameIdExistsValidator(repository);
        final boolean isValid = validator.validate(gameId);
        assertThat(isValid).isTrue();
    }
}