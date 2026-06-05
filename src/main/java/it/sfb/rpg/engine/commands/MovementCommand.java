package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.labyrinth.EDirections;
import it.sfb.rpg.labyrinth.RCoordinate;
import it.sfb.rpg.labyrinth.Room;

public class MovementCommand implements ICommandHandler {

    @Override
    public void handle(GameContext gameContext, String command) {

        EDirections chosenDirection = EDirections.valueOf(command.toUpperCase());
        RCoordinate playerPosition = gameContext.getPlayerPosition();
        RCoordinate nextRoomCoordinates = playerPosition.calculateNeighborRoom(chosenDirection);

        if (gameContext.getLabyrinth().roomIsThere(nextRoomCoordinates)) {
            gameContext.setPlayerPosition(nextRoomCoordinates);
            Room currentRoom = gameContext.getCurrentRoom();
            System.out.println("You have moved to " + currentRoom.getName());
            currentRoom.triggerEvent(gameContext.getPlayer());

        } else {
            System.out.println("You cannot move in that direction");
        }
    }

    public void lookAround(GameContext gameContext, EDirections lookDirection) {

        RCoordinate currentPos = gameContext.getPlayerPosition();
        RCoordinate nextRoomCoordinates = currentPos.calculateNeighborRoom(lookDirection);

        if (!gameContext.getCurrentRoom().getAvailableDirections().contains(lookDirection)) {
            System.out.println("There is no path in that direction, you see nothing");
            return;
        }

        if (!gameContext.getLabyrinth().roomIsThere(nextRoomCoordinates)) {
            System.out.println("You see nothing");
            return;
        }

        Room adjacentRoom = gameContext.getLabyrinth().getRoomPosition(nextRoomCoordinates);
        System.out.println("You see " + adjacentRoom.getName());
    }
}
