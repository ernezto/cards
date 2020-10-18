package org.logmein.cards.data.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nickname;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id")
    private Set<CardEntity> cards;
}
