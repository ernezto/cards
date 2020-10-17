package org.logmein.cards.web.validations.game;

import lombok.AllArgsConstructor;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.web.validations.CustomConstraintValidator;

import java.util.Optional;

@AllArgsConstructor
public class GameIdExistsValidator extends CustomConstraintValidator<GameIdExists, Integer> {
    private final GameRepository repository;

    @Override
    public boolean validate(Integer gameId) {
        Optional<Game> optionalGame = repository.find(gameId);
        return optionalGame.isPresent();
    }
}
