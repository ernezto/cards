package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.domain.models.Game;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = DeckEntityMapper.class)
public interface GameEntityMapper {
    Game toDomain(GameEntity entity);

    GameEntity toData(Game game);
}
