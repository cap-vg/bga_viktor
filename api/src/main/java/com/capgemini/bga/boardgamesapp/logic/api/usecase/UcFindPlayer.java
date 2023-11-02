package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerSearchCriteriaTo;

public interface UcFindPlayer {

    /**
     * Returns a Player by its id 'id'.
     *
     * @param id The id 'id' of the Player.
     * @return The {@link PlayerEto} with id 'id'
     */
    PlayerEto findPlayer(long id);

    /**
     * Returns a paginated list of Players matching the search criteria.
     *
     * @param criteria the {@link PlayerSearchCriteriaTo}.
     * @return the {@link List} of matching {@link PlayerEto}s.
     */
    Page<PlayerEto> findPlayers(PlayerSearchCriteriaTo criteria);

}
