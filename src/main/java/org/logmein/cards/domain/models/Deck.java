package org.logmein.cards.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Stack;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

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

    public List<Card> undealtCards() {
        return cards.stream().filter(Card::isInDeck).collect(toList());
    }

    public int size() {
        return undealtCards().size();
    }

    public void shuffleFromPositions(Stack<Integer> positions) {
        cards.forEach(card -> card.setIndex(positions.pop()));
    }
}
