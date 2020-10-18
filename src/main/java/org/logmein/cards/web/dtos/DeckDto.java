package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Player;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("GameData")
public class GameDto {private Integer id;
    private String name;
    private List<Player> players;
    private List<Deck> decks = new ArrayList<>();
}
