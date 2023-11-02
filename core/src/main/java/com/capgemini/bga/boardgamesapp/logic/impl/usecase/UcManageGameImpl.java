package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGame;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractGameUc;

/**
 * Use case implementation for modifying and deleting Games
 */
@Named
@Validated
@Transactional
public class UcManageGameImpl extends AbstractGameUc implements UcManageGame {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcManageGameImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_GAME)
    public boolean deleteGame(long gameId) {

        GameEntity game = getGameRepository().find(gameId);
        getGameRepository().delete(game);
        LOG.debug("The game with id '{}' has been deleted.", gameId);
        return true;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_GAME)
    public GameEto saveGame(GameEto game) {

        Objects.requireNonNull(game, "game");

        GameEntity gameEntity = getBeanMapper().map(game, GameEntity.class);

        // initialize, validate gameEntity here if necessary
        GameEntity resultEntity = getGameRepository().save(gameEntity);
        LOG.debug("Game with id '{}' has been created.", resultEntity.getId());
        return getBeanMapper().map(resultEntity, GameEto.class);
    }
}
