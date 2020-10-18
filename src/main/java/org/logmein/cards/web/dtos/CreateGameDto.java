package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ApiModel("Game")
public class CreateGameDto {
    @NotEmpty
    private String name;

    private List<CreatePlayerDto> players;
}
