package org.logmein.cards.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "deck")
public class DeckEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "deck_id")
    private List<CardEntity> cards;
}
