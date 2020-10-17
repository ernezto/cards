package org.logmein.cards.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.GameRepository;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    private GameRepository repository;
    private GameService service;

    @BeforeEach
    void setUp() {
        service = new GameService(repository);
    }

    @Test
    public void shouldCreateANewGame() {
        final Game game = mock(Game.class);
        final Game expectedGame = mock(Game.class);
        when(repository.save(game)).thenReturn(expectedGame);
        Game actualGame = service.create(game);
        assertThat(actualGame).isEqualTo(expectedGame);
    }
}