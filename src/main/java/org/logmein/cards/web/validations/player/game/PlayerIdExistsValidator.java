package org.logmein.cards.web.validations.player.game;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.logmein.cards.web.validations.CustomConstraintValidator;

import java.util.Optional;

@AllArgsConstructor
public class PlayerIdExistsValidator extends CustomConstraintValidator<PlayerIdExists, Integer> {
    private final PlayerRepository repository;

    @Override
    public boolean validate(Integer playerId) {
        Optional<Player> optionalGame = repository.find(playerId);
        return optionalGame.isPresent();
    }
}
