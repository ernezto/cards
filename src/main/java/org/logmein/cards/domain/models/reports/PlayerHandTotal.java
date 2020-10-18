package org.logmein.cards.domain.models.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerHandTotal {
    private Integer playerId;
    private String nickname;
    private Integer handTotalValue;
}
