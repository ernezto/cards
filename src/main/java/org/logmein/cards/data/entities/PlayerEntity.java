package org.logmein.cards.data.entities;


import lombok.Data;
import org.logmein.cards.domain.models.FaceType;
import org.logmein.cards.domain.models.SuitType;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nickname;
}
