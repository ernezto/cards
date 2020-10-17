package org.logmein.cards.data.repositories;

import lombok.AllArgsConstructor;
import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.data.mappers.GameEntityMapper;
import org.logmein.cards.data.repositories.jpa.GameJPARepository;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Optional.*;

@Repository
@AllArgsConstructor
public class GameDbRepository implements GameRepository {
    private final GameEntityMapper mapper;
    private final GameJPARepository repository;

    @Override
    public Game save(Game game) {
        final GameEntity entity = mapper.toData(game);
        final GameEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Game> find(int id) {
        final Optional<GameEntity> entity = repository.findById(id);
        return entity.map(mapper::toDomain);
    }

    @Override
    public void delete(int gameId) {
        repository.deleteById(gameId);
    }
}
