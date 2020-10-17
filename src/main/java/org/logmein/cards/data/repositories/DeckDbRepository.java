package org.logmein.cards.data.repositories;

import lombok.AllArgsConstructor;
import org.logmein.cards.data.entities.DeckEntity;
import org.logmein.cards.data.mappers.DeckEntityMapper;
import org.logmein.cards.data.repositories.jpa.DeckJPARepository;
import org.logmein.cards.domain.models.Deck;
import org.logmein.cards.domain.repositories.DeckRepository;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeckDbRepository implements DeckRepository {
    private final DeckEntityMapper mapper;
    private final DeckJPARepository repository;

    @Override
    public Deck save(Deck deck) {
        final DeckEntity entity = mapper.toData(deck);
        final DeckEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Deck find(int id) {
        return null;
    }
}
