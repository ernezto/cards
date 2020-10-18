package org.logmein.cards.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

@Data
@NoArgsConstructor
public class Deck {
    private Integer id;
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Card nextCard() {
        return cards.stream().filter(Card::isInDeck).min(comparingInt(Card::getIndex)).orElse(null);
    }
}
