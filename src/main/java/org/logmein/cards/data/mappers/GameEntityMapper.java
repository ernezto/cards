package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.domain.models.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {DeckEntityMapper.class, CardEntityMapper.class})
public interface GameEntityMapper {

    @Mapping(target = "undealtCards", ignore = true)
    Game toDomain(GameEntity entity);

    GameEntity toData(Game game);

}
