package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.services.GameService;
import org.logmein.cards.web.dtos.CreateGameDto;
import org.logmein.cards.web.mappers.GameDtoMapper;
import org.logmein.cards.web.validations.game.GameIdExists;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/games")
@Api(tags = {"Game REST Operations"})
public class GameResource {
    private final GameService service;
    private final GameDtoMapper mapper;

    @PostMapping
    @ApiOperation(value = "Creates a new game")
    public Game create(@Valid @RequestBody CreateGameDto createGameDto) {
        Game game = mapper.toDomain(createGameDto);
        return service.create(game);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes an existing game")
    public void delete(@GameIdExists @PathVariable("id") Integer gameId) {
        service.delete(gameId);
    }

}
