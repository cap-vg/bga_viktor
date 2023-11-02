package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameSearchCriteriaTo;

public interface UcFindGame {

    /**
     * Returns a Game by its id 'id'.
     *
     * @param id The id 'id' of the Game.
     * @return The {@link GameEto} with id 'id'
     */
    GameEto findGame(long id);

    /**
     * Returns a paginated list of Games matching the search criteria.
     *
     * @param criteria the {@link GameSearchCriteriaTo}.
     * @return the {@link List} of matching {@link GameEto}s.
     */
    Page<GameEto> findGames(GameSearchCriteriaTo criteria);

}
