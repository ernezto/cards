package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.logmein.cards.web.validations.player.game.PlayerIdExists;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("player id")
public class AddPlayerToGameOperationDto {
    @NotNull
    @PlayerIdExists
    private Integer playerId;
}
