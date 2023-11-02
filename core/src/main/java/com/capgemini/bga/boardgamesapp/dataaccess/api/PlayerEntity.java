package com.capgemini.bga.boardgamesapp.dataaccess.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.capgemini.bga.boardgamesapp.common.api.Player;
import com.capgemini.bga.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "player")
public class PlayerEntity extends ApplicationPersistenceEntity implements Player {

    private String name;

    private List<GamePlayEntity> gamePlays = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    /**
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name the new value.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return gamePlays
     */
    @ManyToMany(mappedBy = "players")
    public List<GamePlayEntity> getGamePlays() {

        return this.gamePlays;
    }

    /**
     * @param gamePlays the new value.
     */
    public void setGamePlays(List<GamePlayEntity> gamePlays) {

        this.gamePlays = gamePlays;
    }

}
