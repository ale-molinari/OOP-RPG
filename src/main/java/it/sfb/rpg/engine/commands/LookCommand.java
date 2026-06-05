package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.labyrinth.EDirections;
import it.sfb.rpg.labyrinth.RCoordinate;
import it.sfb.rpg.labyrinth.Room;

public class LookCommand implements ICommandHandler{

    @Override
    public void handle(GameContext gameContext, String argument) {

        EDirections lookDirection = EDirections.valueOf(argument.toUpperCase());
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
