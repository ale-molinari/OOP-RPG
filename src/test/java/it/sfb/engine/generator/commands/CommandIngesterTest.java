package it.sfb.engine.generator.commands;

import it.sfb.rpg.engine.commands.CommandIngester;
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

public class CommandIngesterTest {

    @Test
    public void SuccessfulMovementTest() {
        LabyrinthGenerator generator = new LabyrinthGenerator(42);

        Labyrinth testLabyrinth = generator.generateLabyrinth(3);

        PlayerCharacter player = new PlayerCharacter("Franco", new MagePriest(1,1)) {};
        CommandIngester ingester = new CommandIngester(testLabyrinth, player);

        RCoordinate startingPosition = ingester.getPlayerPosition();
        Room startRoom = testLabyrinth.getRoomPosition(startingPosition);

        EDirections validDirection = startRoom.getAvailableDirections().iterator().next();
        String commandString = validDirection.name();

        ingester.updatePlayerPosition(commandString);

        RCoordinate newPosition = ingester.getPlayerPosition();
        RCoordinate expectedPosition = startingPosition.calculateNeighborRoom(validDirection);

        assertNotEquals(startingPosition, newPosition);

        assertEquals(expectedPosition.x(), newPosition.x());
        assertEquals(expectedPosition.y(), newPosition.y());
    }
}
