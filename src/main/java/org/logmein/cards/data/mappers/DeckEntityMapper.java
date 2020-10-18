package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.DeckEntity;
import org.logmein.cards.domain.models.Deck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = CardEntityMapper.class)
public interface DeckEntityMapper {
    Deck toDomain(DeckEntity entity);

    @Mapping(target = "gameId", ignore = true)
    DeckEntity toData(Deck deck);
}
