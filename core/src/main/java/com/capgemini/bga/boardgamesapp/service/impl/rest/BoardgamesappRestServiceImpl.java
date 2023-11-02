package com.capgemini.bga.boardgamesapp.service.impl.rest;

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
import com.capgemini.bga.boardgamesapp.service.api.rest.BoardgamesappRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Boardgamesapp}.
 */
@Named("BoardgamesappRestService")
public class BoardgamesappRestServiceImpl implements BoardgamesappRestService {

    @Inject
    private Boardgamesapp boardgamesapp;

    @Override
    public GameEto getGame(long id) {

        return this.boardgamesapp.findGame(id);
    }

    @Override
    public GameEto saveGame(GameEto game) {

        return this.boardgamesapp.saveGame(game);
    }

    @Override
    public void deleteGame(long id) {

        this.boardgamesapp.deleteGame(id);
    }

    @Override
    public Page<GameEto> findGames(GameSearchCriteriaTo searchCriteriaTo) {

        return this.boardgamesapp.findGames(searchCriteriaTo);
    }

    @Override
    public GamePlayEto getGamePlay(long id) {

        return this.boardgamesapp.findGamePlay(id);
    }

    @Override
    public GamePlayEto saveGamePlay(GamePlayEto gameplay) {

        return this.boardgamesapp.saveGamePlay(gameplay);
    }

    @Override
    public void deleteGamePlay(long id) {

        this.boardgamesapp.deleteGamePlay(id);
    }

    @Override
    public Page<GamePlayEto> findGamePlays(GamePlaySearchCriteriaTo searchCriteriaTo) {

        return this.boardgamesapp.findGamePlays(searchCriteriaTo);
    }

    @Override
    public PlayerEto getPlayer(long id) {

        return this.boardgamesapp.findPlayer(id);
    }

    @Override
    public PlayerEto savePlayer(PlayerEto player) {

        return this.boardgamesapp.savePlayer(player);
    }

    @Override
    public void deletePlayer(long id) {

        this.boardgamesapp.deletePlayer(id);
    }

    @Override
    public Page<PlayerEto> findPlayers(PlayerSearchCriteriaTo searchCriteriaTo) {

        return this.boardgamesapp.findPlayers(searchCriteriaTo);
    }

}
