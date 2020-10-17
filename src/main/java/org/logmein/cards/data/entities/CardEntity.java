package org.logmein.cards.data.entities;


import lombok.Data;
import org.logmein.cards.domain.models.FaceType;
import org.logmein.cards.domain.models.SuitType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity(name = "card")
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
}
