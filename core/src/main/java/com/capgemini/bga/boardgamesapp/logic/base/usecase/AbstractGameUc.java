package com.capgemini.bga.boardgamesapp.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.bga.boardgamesapp.dataaccess.api.repo.GameRepository;
import com.capgemini.bga.general.logic.base.AbstractUc;

/**
 * Abstract use case for Games, which provides access to the commonly necessary data access objects.
 */
public abstract class AbstractGameUc extends AbstractUc {

    /**
     * @see #getGameRepository()
     */
    @Inject
    private GameRepository gameRepository;

    /**
     * @return the {@link GameRepository} instance.
     */
    public GameRepository getGameRepository() {

        return this.gameRepository;
    }

}
