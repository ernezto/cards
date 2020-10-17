package org.logmein.cards.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.data.entities.DeckEntity;
import org.logmein.cards.data.mappers.DeckEntityMapper;
import org.logmein.cards.data.repositories.jpa.DeckJPARepository;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeckDbRepositoryTest {
    @Mock(stubOnly = true)
    private DeckJPARepository jpaRepository;
    @Mock
    private DeckEntityMapper mapper;
    @Mock
    private Deck deck;
    @Mock
    private DeckEntity entity;
    @Mock
    private DeckEntity savedEntity;
    @Mock
    private Deck expectedDeck;

    private DeckRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new DeckDbRepository(mapper, jpaRepository);
    }

    @Test
    public void shouldSaveADeck() {
        when(mapper.toData(deck)).thenReturn(entity);
        when(jpaRepository.save(entity)).thenReturn(savedEntity);
        when(mapper.toDomain(savedEntity)).thenReturn(expectedDeck);
        final Deck savedDeck = repository.save(deck);
        assertThat(savedDeck).isEqualTo(expectedDeck);
    }
}