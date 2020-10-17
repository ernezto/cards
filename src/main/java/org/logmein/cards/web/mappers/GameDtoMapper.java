package org.logmein.cards.web.mappers;

import org.logmein.cards.domain.models.Game;
import org.logmein.cards.web.dtos.CreateGameDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GameDtoMapper {

    Game toDomain(CreateGameDto dto);
}
