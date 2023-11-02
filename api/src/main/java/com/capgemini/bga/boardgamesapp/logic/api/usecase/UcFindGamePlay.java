package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlaySearchCriteriaTo;

public interface UcFindGamePlay {

    /**
     * Returns a GamePlay by its id 'id'.
     *
     * @param id The id 'id' of the GamePlay.
     * @return The {@link GamePlayEto} with id 'id'
     */
    GamePlayEto findGamePlay(long id);

    /**
     * Returns a paginated list of GamePlays matching the search criteria.
     *
     * @param criteria the {@link GamePlaySearchCriteriaTo}.
     * @return the {@link List} of matching {@link GamePlayEto}s.
     */
    Page<GamePlayEto> findGamePlays(GamePlaySearchCriteriaTo criteria);

}
