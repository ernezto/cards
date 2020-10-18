package org.logmein.cards.web.controllers;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.services.GameService;
import org.logmein.cards.web.dtos.CreateGameDto;
import org.logmein.cards.web.mappers.GameDtoMapper;
import org.logmein.cards.web.validations.game.GameIdExists;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Valid;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameResourceTest {
    private final EasyRandom random = new EasyRandom();
    @Mock
    private GameService service;
    @Mock(stubOnly = true)
    private GameDtoMapper mapper;
    private GameResource resource;

    @BeforeEach
    void setUp() {
        resource = new GameResource(service, mapper);
    }

    @Test
    public void shouldValidateWhenCreatingANewGame() throws NoSuchMethodException {
        Method create = GameResource.class.getMethod("create", CreateGameDto.class);
        Parameter createGameDtoParameter = create.getParameters()[0];
        assertThat(createGameDtoParameter.getAnnotation(Valid.class)).isNotNull();
    }

    @Test
    public void shouldCreateANewGame() {
        final CreateGameDto gameDto = random.nextObject(CreateGameDto.class);
        final Game game = random.nextObject(Game.class);
        final Game expectedGame = random.nextObject(Game.class);
        when(mapper.toDomain(gameDto)).thenReturn(game);
        when(service.create(game)).thenReturn(expectedGame);
        final Game actualGame = resource.create(gameDto);
        assertThat(actualGame).isEqualTo(expectedGame);
    }

    @Test
    public void shouldDeleteAGame() {
        final int gameId = random.nextInt();
        resource.delete(gameId);
        verify(service, times(1)).delete(gameId);
    }

    @Test
    public void shouldValidateGameIdBeforeDeleting() throws NoSuchMethodException {
        Method delete = GameResource.class.getMethod("delete", Integer.class);
        Parameter createGameDtoParameter = delete.getParameters()[0];
        assertThat(createGameDtoParameter.getAnnotation(GameIdExists.class)).isNotNull();
    }
}