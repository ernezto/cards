package org.logmein.cards.domain.models;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class DeckBuilder {

    protected DeckBuilder() {
    }

    public static DeckBuilder classic() {
        return new DeckBuilder();
    }

    public Deck build() {
        List<Card> cards = stream(SuitType.values())
                .flatMap(s -> stream(FaceType.values()).map(f -> new Card( s, f, 0)))
                .collect(toList());
        return new Deck(cards);
    }
}
