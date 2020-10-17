package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("Game")
public class CreateGameDto {
    @NotEmpty
    private String name;
}
