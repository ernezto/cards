package org.logmein.cards.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Integer id;
    private SuitType suit;
    private FaceType face;
    private Integer index;
}
