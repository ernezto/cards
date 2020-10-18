package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.services.DeckService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;


@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/decks")
@Api(tags = {"Deck"})
public class DeckResource {
    private final DeckService deckService;

    @ResponseStatus(CREATED)
    @PostMapping
    @ApiOperation(value = "Creates a classic deck of 52 cards")
    public Deck create() {
        return deckService.create();
    }
}
