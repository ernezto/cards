package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ApiModel("GameData")
public class CreateGameDto {
    @NotEmpty
    private String name;

    @Valid
    private List<CreatePlayerDto> players;
}
