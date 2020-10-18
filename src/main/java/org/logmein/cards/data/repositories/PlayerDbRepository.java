package org.logmein.cards.data.repositories;

import lombok.AllArgsConstructor;
import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.data.entities.PlayerEntity;
import org.logmein.cards.data.mappers.GameEntityMapper;
import org.logmein.cards.data.mappers.PlayerEntityMapper;
import org.logmein.cards.data.repositories.jpa.GameJPARepository;
import org.logmein.cards.data.repositories.jpa.PlayerJPARepository;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.models.Player;
import org.logmein.cards.domain.repositories.GameRepository;
import org.logmein.cards.domain.repositories.PlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PlayerDbRepository implements PlayerRepository {
    private final PlayerEntityMapper mapper;
    private final PlayerJPARepository repository;

    @Override
    public Player save(Player player) {
        final PlayerEntity entity = mapper.toData(player);
        PlayerEntity savedEntity = repository.save(entity);
        return get(savedEntity.getId());
    }

    @Override
    public Optional<Player> find(Integer id) {
        final Optional<PlayerEntity> entity = repository.findById(id);
        return entity.map(mapper::toDomain);
    }

    @Override
    public void delete(Integer gameId) {
        repository.deleteById(gameId);
    }

    @Override
    public Player get(Integer id) {
        return find(id).orElse(null);
    }
}
