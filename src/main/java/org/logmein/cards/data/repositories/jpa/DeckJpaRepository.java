package org.logmein.cards.data.repositories.jpa;

import org.logmein.cards.data.entities.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckJpaRepository extends JpaRepository<DeckEntity, Integer> {
}
