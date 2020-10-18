package org.logmein.cards.domain.models.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.logmein.cards.domain.models.FaceType;
import org.logmein.cards.domain.models.SuitType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardCountBySuitAndValue {
    private SuitType suit;
    private FaceType face;
    private Integer value;
    private Integer total;
}
