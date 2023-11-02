package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlaySearchCriteriaTo;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindGamePlay;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractGamePlayUc;

/**
 * Use case implementation for searching, filtering and getting GamePlays
 */
@Named
@Validated
@Transactional
public class UcFindGamePlayImpl extends AbstractGamePlayUc implements UcFindGamePlay {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcFindGamePlayImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_GAMEPLAY)
    public GamePlayEto findGamePlay(long id) {

        LOG.debug("Get GamePlay with id {} from database.", id);
        Optional<GamePlayEntity> foundEntity = getGamePlayRepository().findById(id);
        if (foundEntity.isPresent())
            return getBeanMapper().map(foundEntity.get(), GamePlayEto.class);
        else
            return null;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_GAMEPLAYS)
    public Page<GamePlayEto> findGamePlays(GamePlaySearchCriteriaTo criteria) {

        Page<GamePlayEntity> gameplays = getGamePlayRepository().findByCriteria(criteria);
        return mapPaginatedEntityList(gameplays, GamePlayEto.class);
    }

}
