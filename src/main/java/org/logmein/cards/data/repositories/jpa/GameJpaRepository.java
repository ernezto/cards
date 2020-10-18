package org.logmein.cards.data.repositories.jpa;

import org.logmein.cards.data.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameJpaRepository extends JpaRepository<GameEntity, Integer> {
}
