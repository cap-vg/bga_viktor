package com.capgemini.bga.boardgamesapp.dataaccess.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.capgemini.bga.boardgamesapp.common.api.GamePlay;
import com.capgemini.bga.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "game_play")
public class GamePlayEntity extends ApplicationPersistenceEntity implements GamePlay {

    private GameEntity game;

    private BigDecimal duration;

    private List<PlayerEntity> players = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @Transient
    public Long getGameId() {

        if (this.game == null) {
            return null;
        }
        return this.game.getId();
    }

    public void setGameId(Long gameId) {

        if (gameId == null) {
            this.game = null;
        } else {
            GameEntity gameEntity = new GameEntity();
            gameEntity.setId(gameId);
            this.game = gameEntity;
        }
    }

    /**
     * @return game
     */
    @ManyToOne
    public GameEntity getGame() {

        return this.game;
    }

    /**
     * @param game the new value.
     */
    public void setGame(GameEntity game) {

        this.game = game;
    }

    /**
     * @return duration
     */
    public BigDecimal getDuration() {

        return this.duration;
    }

    /**
     * @param duration the new value.
     */
    public void setDuration(BigDecimal duration) {

        this.duration = duration;
    }

    /**
     * @return players
     */
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "game_play_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    public List<PlayerEntity> getPlayers() {

        return this.players;
    }

    /**
     * @param players the new value.
     */
    public void setPlayers(List<PlayerEntity> players) {

        this.players = players;
    }

    public void addPlayer(PlayerEntity player) {

        this.players.add(player);
        player.getGamePlays().add(this);
    }

    public void removePlayer(PlayerEntity player) {

        this.players.remove(player);
        player.getGamePlays().remove(this);
    }

}
