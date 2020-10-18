package org.logmein.cards.domain.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.collect.Lists.cartesianProduct;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class DeckBuilderTest {

    @Test
    public void shouldCreateAClassic52CardsDeck() {
        final List<Card> expectedCards = cartesianProduct(asList(SuitType.values()), asList(FaceType.values()))
                .stream()
                .map(p -> new Card((SuitType) p.get(0), (FaceType) p.get(1), 0))
                .collect(toList());
        final Deck deck = DeckBuilder.classic().build();
        assertThat(deck.getCards())
                .usingElementComparatorIgnoringFields("id")
                .containsAll(expectedCards);
    }
}