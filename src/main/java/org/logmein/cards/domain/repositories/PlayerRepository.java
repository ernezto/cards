package org.logmein.cards.domain.repositories;

import org.logmein.cards.domain.models.Player;

import java.util.Optional;

public interface PlayerRepository {
    Player save(Player player);

    Optional<Player> find(Integer playerId);

    void delete(Integer gameId);

    Player get(Integer playerId);
}
