package org.logmein.cards.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    private GameRepository gameRepository;
    @Mock
    private DeckRepository deckRepository;
    @Mock
    private PlayerRepository playerRepository;
    private GameService service;

    @BeforeEach
    void setUp() {
        service = new GameService(gameRepository, deckRepository, playerRepository);
    }

    @Test
    public void shouldCreateANewGame() {
        final Game game = mock(Game.class);
        final Game expectedGame = mock(Game.class);
        when(gameRepository.save(game)).thenReturn(expectedGame);
        Game actualGame = service.create(game);
        assertThat(actualGame).isEqualTo(expectedGame);
    }
}