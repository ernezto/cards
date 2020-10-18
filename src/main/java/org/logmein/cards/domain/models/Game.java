package org.logmein.cards.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Integer id;
    private String name;
    private List<Player> players;
    private List<Deck> decks = new ArrayList<>();

    public void addDeck(Deck deck) {
        decks.add(deck);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Integer playerId) {
        players = players
                .stream()
                .filter(p -> !p.hasId(playerId))
                .collect(toList());
    }
}
