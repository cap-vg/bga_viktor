package com.capgemini.bga.boardgamesapp.common.api;

import java.math.BigDecimal;

import com.capgemini.bga.general.common.api.ApplicationEntity;

public interface GamePlay extends ApplicationEntity {

    /**
     * getter for gameId attribute
     *
     * @return gameId
     */

    public Long getGameId();

    /**
     * @param gameId setter for gameId attribute
     */

    public void setGameId(Long gameId);

    /**
     * @return duration
     */

    public BigDecimal getDuration();

    /**
     * @param duration setter for duration attribute
     */

    public void setDuration(BigDecimal duration);

}
