package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.logmein.cards.web.validations.deck.DeckIdExists;
import org.logmein.cards.web.validations.deck.DeckNotAssigned;
import org.logmein.cards.web.validations.player.game.PlayerIdExists;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("deck id")
public class AddDeckToGameOperationDto {
    @NotNull
    @DeckIdExists
    @DeckNotAssigned
    private Integer deckId;
}
