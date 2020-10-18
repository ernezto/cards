package org.logmein.cards.domain.models;

import lombok.Data;

@Data
public class Player {
    private Integer id;
    private String nickname;

    public boolean hasId(Integer playerId) {
        return id.equals(playerId);
    }
}
