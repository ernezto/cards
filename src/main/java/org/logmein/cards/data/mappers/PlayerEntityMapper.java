package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.PlayerEntity;
import org.logmein.cards.domain.models.Player;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PlayerEntityMapper {
    PlayerEntity toData(Player player);
    Player toDomain(PlayerEntity entity);
}
