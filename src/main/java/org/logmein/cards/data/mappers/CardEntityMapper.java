package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.CardEntity;
import org.logmein.cards.domain.models.Card;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@Mapper(componentModel = "spring")
public interface CardEntityMapper {


    @Mapping(target = "inDeck", source = "playerId", qualifiedByName = "InDeckMapper")
    Card toDomain(CardEntity entity);

    @Mapping(target = "playerId", ignore = true)
    CardEntity toData(Card card);

    @Named("InDeckMapper")
    default boolean isInDeck(Integer playerId) {
        return isNull(playerId);
    }
}
