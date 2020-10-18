package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.services.PlayerService;
import org.logmein.cards.web.dtos.CreatePlayerDto;
import org.logmein.cards.web.mappers.PlayerDtoMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@AllArgsConstructor
@RequestMapping("/players")
@Api(tags = {"Player"})
public class PlayerResource {
    private final PlayerService playerService;
    private final PlayerDtoMapper mapper;

    @ResponseStatus(CREATED)
    @PostMapping
    @ApiOperation(value = "Creates a new player")
    public Player create(@Valid @RequestBody CreatePlayerDto createPlayerDto) {
        final Player player = mapper.toDomain(createPlayerDto);
        return playerService.create(player);
    }
}
