package org.logmein.cards.web.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.reports.PlayerReport;
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
    @ApiOperation(value = "Gets all players per game with accumulated hand's value sorted descending from highest value to lowest")
    public List<PlayerReport> sortedPlayers(@GameIdExists @PathVariable("gameId") Integer gameId) {
        return reportService.getPlayerHands(gameId);
    }


}
