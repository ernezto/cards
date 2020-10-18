package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.services.GameService;
import org.logmein.cards.web.dtos.AddDeckToGameOperationDto;
import org.logmein.cards.web.dtos.PlayerIdDto;
import org.logmein.cards.web.dtos.CreateGameDto;
import org.logmein.cards.web.mappers.GameDtoMapper;
import org.logmein.cards.web.validations.game.GameIdExists;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;


@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/games")
@Api(tags = {"Game"})
public class GameResource {
    private final GameService service;
    private final GameDtoMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
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

    @PatchMapping("/{gameId}/decks")
    @ApiOperation(value = "Adds an available deck to an existing game")
    public Game addDeckToGame(@GameIdExists @PathVariable("gameId") Integer gameId,
                              @Valid @RequestBody AddDeckToGameOperationDto deckAdditionOperation) {
        return service.addDeckToGame(gameId, deckAdditionOperation.getDeckId());
    }

    @PatchMapping("/{gameId}/players")
    @ApiOperation(value = "Adds an existing player to an existing game")
    public Game addPlayerToGame(@GameIdExists @PathVariable("gameId") Integer gameId,
                                @Valid @RequestBody PlayerIdDto playerToBeAdded) {
        return service.addPlayerToGame(gameId, playerToBeAdded.getPlayerId());
    }

    @DeleteMapping("/{gameId}/players/{playerId}")
    @ApiOperation(value = "Removes an existing player from a game")
    public Game removeDeckToGame(@GameIdExists @PathVariable("gameId") Integer gameId,
                                 @Valid @RequestBody PlayerIdDto playerToBeRemoved) {
        return service.removePlayerFromGame(gameId, playerToBeRemoved.getPlayerId());
    }
}
