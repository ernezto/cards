package org.logmein.cards.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.data.mappers.GameEntityMapper;
import org.logmein.cards.data.repositories.jpa.GameJpaRepository;
import org.logmein.cards.domain.models.Game;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameDbRepositoryTest {
    @Mock(stubOnly = true)
    private GameJpaRepository jpaRepository;
    @Mock
    private GameEntityMapper mapper;
    @Mock
    private Game game;
    @Mock
    private GameEntity entity;
    @Mock
    private GameEntity savedEntity;
    @Mock
    private Game expectedGame;

    private GameDbRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new GameDbRepository(mapper, jpaRepository);
    }

    @Test
    public void shouldSaveADeck() {
        when(mapper.toData(game)).thenReturn(entity);
        when(jpaRepository.save(entity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(expectedGame);
        final Game savedGame = repository.save(game);
        assertThat(savedGame).isEqualTo(expectedGame);
    }
}
