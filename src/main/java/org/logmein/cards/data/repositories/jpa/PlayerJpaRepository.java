package org.logmein.cards.data.repositories.jpa;

import org.logmein.cards.data.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Integer> {
//    @Query("SELECT player FROM PlayerEntity player " +
//            "INNER JOIN player.games game " +
//            "WHERE game.id = :gameId")
//    List<PlayerEntity> findAllPlayersByGameId(@Param("gameId") Integer gameId);
}
