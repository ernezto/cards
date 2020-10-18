package org.logmein.cards.data.repositories.jpa;

import org.logmein.cards.data.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerJPARepository extends JpaRepository<PlayerEntity, Integer> {
}