package it.sfb.rpg.engine.commands;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.labyrinth.EDirections;
import it.sfb.rpg.labyrinth.Labyrinth;
import it.sfb.rpg.labyrinth.RCoordinate;
import it.sfb.rpg.labyrinth.Room;

public class CommandIngester {

    private RCoordinate playerPosition;
    private final Labyrinth labyrinth;
    private final PlayerCharacter player;

    public CommandIngester(Labyrinth labyrinth, PlayerCharacter player) {
        this.labyrinth = labyrinth;
        this.player = player;
        this.playerPosition = new RCoordinate(0,0);
    }

    public RCoordinate getPlayerPosition() {
        return playerPosition;
    }

    public void updatePlayerPosition(String command) {

        EDirections chosenDirection = EDirections.valueOf(command);
        RCoordinate nextRoomCoordinates = playerPosition.calculateNeighborRoom(chosenDirection);

        if (labyrinth.roomIsThere(nextRoomCoordinates)) {
            playerPosition = nextRoomCoordinates;
            Room nextRoomObject = labyrinth.getRoomPosition(nextRoomCoordinates);
            System.out.println("You have moved to " + nextRoomObject.getName());
            nextRoomObject.triggerEvent(this.player);

        } else {
            System.out.println("You cannot move in that direction");
        }
    }

    public void lookAround(String command) {

        EDirections lookDirection;

        try {
            lookDirection = EDirections.valueOf(command);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid direction");
            return;
        }

        Room currentRoom = labyrinth.getRoomPosition(playerPosition);

        if (!currentRoom.getAvailableDirections().contains(lookDirection)) {
            System.out.println("You see nothing");
            return;
        }

        RCoordinate nextRoomCoordinates = playerPosition.calculateNeighborRoom(lookDirection);

        if (!labyrinth.roomIsThere(nextRoomCoordinates)) {
            System.out.println("You see nothing");
            return;
        }

        Room adjacentRoom = labyrinth.getRoomPosition(nextRoomCoordinates);
        System.out.println("You see " + adjacentRoom.getName());
    }
}
