package org.logmein.cards.domain.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.DeckBuilder;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeckServiceTest {
    @Mock(stubOnly = true)
    private DeckRepository repository;

    @Test
    public void shouldCreateAClassicDeckOfCards() {
        final DeckService service = new DeckService(repository);
        final Deck deck = DeckBuilder.classic().build();
        final Deck expectedDeck = mock(Deck.class);
        when(repository.save(deck)).thenReturn(expectedDeck);
        Deck actualDeck = service.create();
        assertThat(actualDeck).isEqualTo(expectedDeck);
    }
}