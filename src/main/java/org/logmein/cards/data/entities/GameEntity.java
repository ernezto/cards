package org.logmein.cards.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = ALL, orphanRemoval = true, fetch = EAGER)
    @JoinColumn(name = "game_id", nullable = false)
    private List<DeckEntity> decks = new ArrayList<>();

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "player_game",
            joinColumns = {@JoinColumn(name = "game_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "player_id", nullable = false)}
    )
    private Set<PlayerEntity> players = new HashSet<>();
}
