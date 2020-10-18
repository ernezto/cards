package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Card;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.services.PlayerService;
import org.logmein.cards.web.dtos.CreatePlayerDto;
import org.logmein.cards.web.mappers.PlayerDtoMapper;
import org.logmein.cards.web.validations.player.game.PlayerIdExists;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@Validated
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

    @GetMapping("/{id}/cards")
    @ApiOperation(value = "Gets all the cards by player irrespective of the game")
    public List<Card> getAllCards(@PlayerIdExists @PathVariable("id") Integer playerId) {
        return playerService.getPlayerCards(playerId);
    }

}
