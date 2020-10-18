package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.reports.CardCountBySuitAndValue;
import org.logmein.cards.domain.models.reports.CardTotalBySuit;
import org.logmein.cards.domain.models.reports.PlayerHandTotal;
import org.logmein.cards.domain.services.ReportService;
import org.logmein.cards.web.validations.game.GameIdExists;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/reports")
@Api(tags = {"Report"})
public class ReportResource {
    private final ReportService reportService;

    @GetMapping("players/games/{gameId}")
    @ApiOperation(value = "Gets all players by game with accumulated hand's value sorted descending from highest value to lowest")
    public List<PlayerHandTotal> playersHandValueSortedDesc(@GameIdExists @PathVariable("gameId") Integer gameId) {
        return reportService.playersHandValueSortedDesc(gameId);
    }

    @GetMapping("cards/count-by-suit/games/{gameId}")
    @ApiOperation(value = "Gets number of cards undealt by game deck group by suit")
    public List<CardTotalBySuit> numberOfCardsBySuit(@GameIdExists @PathVariable("gameId") Integer gameId) {
        return reportService.numberOfCardsBySuit(gameId);
    }

    @GetMapping("cards/undealt-by-suit-value/games/{gameId}")
    @ApiOperation(value = "Gets number of cards undealt by suit and value for a game deck sorted by suit and value desc")
    public List<CardCountBySuitAndValue> numberOfCardsBySuitAndValueSortedDesc(@GameIdExists @PathVariable("gameId") Integer gameId) {
        return reportService.numberOfCardsBySuitAndValueSortedDesc(gameId);
    }


}
