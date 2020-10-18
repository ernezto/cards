package org.logmein.cards.data.repositories;

import lombok.AllArgsConstructor;
import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.data.entities.PlayerEntity;
import org.logmein.cards.data.mappers.GameEntityMapper;
import org.logmein.cards.data.mappers.PlayerEntityMapper;
import org.logmein.cards.data.repositories.jpa.GameJpaRepository;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.repositories.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class GameDbRepository implements GameRepository {
    private final GameEntityMapper gameMapper;
    private final PlayerEntityMapper playerMapper;
    private final GameJpaRepository repository;

    @Override
    public Game save(Game game) {
        final GameEntity entity = gameMapper.toData(game);
        GameEntity savedEntity = repository.save(entity);
        return get(savedEntity.getId());
    }

    @Override
    public Optional<Game> find(int id) {
        final Optional<GameEntity> entity = repository.findById(id);
        return entity.map(gameMapper::toDomain);
    }

    @Override
    public void delete(int gameId) {
        repository.deleteById(gameId);
    }

    @Override
    public Game get(Integer id) {
        return find(id).orElse(null);
    }

}
