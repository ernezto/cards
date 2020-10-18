package org.logmein.cards.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.Objects.isNull;
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

    public Player dealCardToPlayer(Integer playerId) {
        Optional<Player> optionalPlayer = players.stream().filter(p -> p.hasId(playerId)).findFirst();
        return optionalPlayer
                .map(player -> pickNextCard().map(player::addCard).orElse(player))
                .orElse(null);
    }

    public Optional<Card> pickNextCard() {
        return decks
                .stream()
                .map(Deck::nextCard)
                .filter(c -> !isNull(c))
                .min(comparingInt(Card::getIndex));
    }

    public List<Card> getUndealtCards() {
        return decks.stream()
                .flatMap(c -> c.undealtCards().stream())
                .collect(toList());
    }
}
