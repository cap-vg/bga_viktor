package com.capgemini.bga.boardgamesapp.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.bga.boardgamesapp.logic.api.Boardgamesapp;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlaySearchCriteriaTo;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameSearchCriteriaTo;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerSearchCriteriaTo;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindGame;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindGamePlay;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindPlayer;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGame;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGamePlay;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManagePlayer;
import com.capgemini.bga.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of boardgamesapp
 */
@Named
public class BoardgamesappImpl extends AbstractComponentFacade implements Boardgamesapp {

    @Inject
    private UcFindGame ucFindGame;

    @Inject
    private UcManageGame ucManageGame;

    @Inject
    private UcFindGamePlay ucFindGamePlay;

    @Inject
    private UcManageGamePlay ucManageGamePlay;

    @Inject
    private UcFindPlayer ucFindPlayer;

    @Inject
    private UcManagePlayer ucManagePlayer;

    @Override
    public GameEto findGame(long id) {

        return this.ucFindGame.findGame(id);
    }

    @Override
    public Page<GameEto> findGames(GameSearchCriteriaTo criteria) {

        return this.ucFindGame.findGames(criteria);
    }

    @Override
    public GameEto saveGame(GameEto game) {

        return this.ucManageGame.saveGame(game);
    }

    @Override
    public boolean deleteGame(long id) {

        return this.ucManageGame.deleteGame(id);
    }

    @Override
    public GamePlayEto findGamePlay(long id) {

        return this.ucFindGamePlay.findGamePlay(id);
    }

    @Override
    public Page<GamePlayEto> findGamePlays(GamePlaySearchCriteriaTo criteria) {

        return this.ucFindGamePlay.findGamePlays(criteria);
    }

    @Override
    public GamePlayEto saveGamePlay(GamePlayEto gameplay) {

        return this.ucManageGamePlay.saveGamePlay(gameplay);
    }

    @Override
    public boolean deleteGamePlay(long id) {

        return this.ucManageGamePlay.deleteGamePlay(id);
    }

    @Override
    public PlayerEto findPlayer(long id) {

        return this.ucFindPlayer.findPlayer(id);
    }

    @Override
    public Page<PlayerEto> findPlayers(PlayerSearchCriteriaTo criteria) {

        return this.ucFindPlayer.findPlayers(criteria);
    }

    @Override
    public PlayerEto savePlayer(PlayerEto player) {

        return this.ucManagePlayer.savePlayer(player);
    }

    @Override
    public boolean deletePlayer(long id) {

        return this.ucManagePlayer.deletePlayer(id);
    }

}
