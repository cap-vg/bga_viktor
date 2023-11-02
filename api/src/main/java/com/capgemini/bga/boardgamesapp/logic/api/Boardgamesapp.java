package com.capgemini.bga.boardgamesapp.logic.api;

import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindGame;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindGamePlay;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindPlayer;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGame;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGamePlay;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManagePlayer;

/**
 * Interface for Boardgamesapp component.
 */
public interface Boardgamesapp
        extends UcFindGame, UcManageGame, UcFindGamePlay, UcManageGamePlay, UcFindPlayer, UcManagePlayer {

}
