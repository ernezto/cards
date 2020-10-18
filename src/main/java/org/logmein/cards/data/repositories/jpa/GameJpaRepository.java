package org.logmein.cards.data.repositories.jpa;

import org.logmein.cards.data.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface GameJPARepository extends JpaRepository<GameEntity, Integer> {

    @Query("SELECT game FROM GameEntity game " +
            "JOIN FETCH game.players players " +
            "JOIN FETCH game.decks decks " +
            "JOIN FETCH decks.cards " +
            "WHERE game.id = :id")
    Optional<GameEntity> findByIdWithCardsAvailable(@Param("id") Integer id);
}
