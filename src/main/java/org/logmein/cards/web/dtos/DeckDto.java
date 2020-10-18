package org.logmein.cards.web.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Player;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("DeckInfo")
public class DeckDto {
    private Integer id;
    private List<Card> cards;
}
