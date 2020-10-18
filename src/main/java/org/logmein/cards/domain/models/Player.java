package org.logmein.cards.domain.models;

import lombok.Data;

import java.util.List;

import static java.lang.Integer.sum;

@Data
public class Player {
    private Integer id;
    private String nickname;
    private List<Card> cards;

    public boolean hasId(Integer playerId) {
        return id.equals(playerId);
    }

    public Player addCard(Card card) {
        cards.add(card);
        return this;
    }

    public Integer handTotalValue() {
        return cards.stream().mapToInt(c -> c.getFace().getValue()).sum();
    }
}
