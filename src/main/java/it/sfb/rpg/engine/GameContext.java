package it.sfb.rpg.engine;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.labyrinth.Labyrinth;
import it.sfb.rpg.labyrinth.RCoordinate;
import it.sfb.rpg.labyrinth.Room;

public class GameContext {
    private final Labyrinth labyrinth;
    private final PlayerCharacter player;
    private RCoordinate playerPosition;

    public GameContext(Labyrinth labyrinth, PlayerCharacter player) {
        this.labyrinth = labyrinth;
        this.player = player;
        this.playerPosition = new RCoordinate(0,0);
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public RCoordinate getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(RCoordinate playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Room getCurrentRoom() {
        return labyrinth.getRoomPosition(playerPosition);
    }

}
