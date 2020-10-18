package org.logmein.cards.web.mappers;

import org.logmein.cards.domain.models.Game;
import org.logmein.cards.web.dtos.CreateGameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = PlayerDtoMapper.class)
public interface GameDtoMapper {

    @Mapping(target = "decks", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "undealtCards", ignore = true)
    Game toDomain(CreateGameDto dto);
}
