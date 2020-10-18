package org.logmein.cards.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "deck")
public class DeckEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "deck_id")
    private Set<CardEntity> cards = new HashSet<>();

    @Column(name = "game_id", insertable = false, updatable = false)
    private Integer gameId;

    public boolean isAssigned() {
        return !isNull(gameId);
    }
}
