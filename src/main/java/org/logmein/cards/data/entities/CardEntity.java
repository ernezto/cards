package org.logmein.cards.data.entities;


import lombok.Data;
import org.logmein.cards.domain.models.FaceType;
import org.logmein.cards.domain.models.SuitType;

import javax.persistence.*;

import static java.util.Objects.isNull;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private SuitType suit;

    @Column(nullable = false)
    private FaceType face;

    @Column(nullable = false)
    private Integer index;

    @Column(name = "player_id", insertable = false, updatable = false)
    private Integer playerId;
}
