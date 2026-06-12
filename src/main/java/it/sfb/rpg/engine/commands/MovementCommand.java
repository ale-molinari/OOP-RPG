package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.labyrinth.EDirections;
import it.sfb.rpg.labyrinth.RCoordinate;
import it.sfb.rpg.labyrinth.Room;

public class MovementCommand implements ICommandHandler {

    /**
     * Executes the movement logic, updating the player's position.
     * @param gameContext the current state of the game
     * @param command the direction string to move towards
     */
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
}
