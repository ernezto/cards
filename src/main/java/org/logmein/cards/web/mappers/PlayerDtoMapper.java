package org.logmein.cards.web.mappers;

import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.web.dtos.CreateGameDto;
import org.logmein.cards.web.dtos.CreatePlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PlayerDtoMapper {

    @Mapping(target = "id", ignore = true)
    Player toDomain(CreatePlayerDto dto);
}
