package org.logmein.cards.data.mappers;

import org.logmein.cards.data.entities.CardEntity;
import org.logmein.cards.domain.models.Card;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CardEntityMapper {
    Card toDomain(CardEntity entity);

    CardEntity toData(Card card);
}
