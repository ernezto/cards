package org.logmein.cards.data.repositories;

import lombok.AllArgsConstructor;
import org.logmein.cards.data.entities.GameEntity;
import org.logmein.cards.data.mappers.GameEntityMapper;
import org.logmein.cards.data.repositories.jpa.GameJPARepository;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.models.Game;
import org.logmein.cards.domain.repositories.GameRepository;
import org.springframework.stereotype.Repository;

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
    public Deck find(int id) {
        return null;
    }
}
