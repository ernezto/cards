package org.logmein.cards.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@Data
@NoArgsConstructor
public class Card {
    private Integer id;
    private SuitType suit;
    private FaceType face;
    private boolean InDeck;
    private Integer index;

    public Card(SuitType suit, FaceType face, Integer index) {
        this.suit = suit;
        this.face = face;
        this.index = index;
    }

}
