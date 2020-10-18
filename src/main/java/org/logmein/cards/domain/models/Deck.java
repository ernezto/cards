package org.logmein.cards.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Deck {
    private Integer id;
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
}
