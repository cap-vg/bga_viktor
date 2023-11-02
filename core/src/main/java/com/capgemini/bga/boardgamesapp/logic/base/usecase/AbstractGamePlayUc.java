package com.capgemini.bga.boardgamesapp.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.bga.boardgamesapp.dataaccess.api.repo.GamePlayRepository;
import com.capgemini.bga.general.logic.base.AbstractUc;

/**
 * Abstract use case for GamePlays, which provides access to the commonly necessary data access objects.
 */
public abstract class AbstractGamePlayUc extends AbstractUc {

    /**
     * @see #getGamePlayRepository()
     */
    @Inject
    private GamePlayRepository gamePlayRepository;

    /**
     * @return the {@link GamePlayRepository} instance.
     */
    public GamePlayRepository getGamePlayRepository() {

        return this.gamePlayRepository;
    }

}
