package it.sfb.engine.commands;

import it.sfb.rpg.engine.commands.MovementController;
import it.sfb.rpg.engine.generator.LabyrinthGenerator;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.MagePriest;
import it.sfb.rpg.labyrinth.EDirections;
import it.sfb.rpg.labyrinth.Labyrinth;
import it.sfb.rpg.labyrinth.RCoordinate;
import it.sfb.rpg.labyrinth.Room;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovementControllerTest {

//    @Test
//    public void SuccessfulMovementTest() {
//        LabyrinthGenerator generator = new LabyrinthGenerator(42);
//
//        Labyrinth testLabyrinth = generator.generateLabyrinth(3);
//
//        PlayerCharacter player = new PlayerCharacter("Franco", new MagePriest(1,1)) {};
//        MovementController controller = new MovementController(testLabyrinth, player);
//
//        RCoordinate startingPosition = controller.getPlayerPosition();
//        Room startRoom = testLabyrinth.getRoomPosition(startingPosition);
//
//        EDirections validDirection = startRoom.getAvailableDirections().iterator().next();
//        String commandString = validDirection.name();
//
//        controller.updatePlayerPosition();
//
//        RCoordinate newPosition = controller.getPlayerPosition();
//        RCoordinate expectedPosition = startingPosition.calculateNeighborRoom(validDirection);
//
//        assertNotEquals(startingPosition, newPosition);
//
//        assertEquals(expectedPosition.x(), newPosition.x());
//        assertEquals(expectedPosition.y(), newPosition.y());
//    }
}
