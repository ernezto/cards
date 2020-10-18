package org.logmein.cards.domain.mappers;

import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.models.reports.PlayerReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PlayerToPlayerReportMapper {

    List<PlayerReport> toPlayerReport(List<Player> players);

    @Mapping(source = "id", target = "playerId")
    @Mapping(source = "player", target = "handTotalValue", qualifiedByName = "CardsToHandTotalValue")
    PlayerReport toPlayerReport(Player player);

    @Named("CardsToHandTotalValue")
    default Integer cardsToTotalHandValue(Player player) {
        return player.handTotalValue();
    }
}
