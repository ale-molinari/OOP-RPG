package it.sfb.engine.generator;

import it.sfb.rpg.engine.generator.LabyrinthGenerator;
import it.sfb.rpg.labyrinth.Labyrinth;
import it.sfb.rpg.labyrinth.RCoordinate;
import org.junit.Assert;
import org.junit.Test;

public class LabyrinthGeneratorTest {

    @Test
    public void LabyrinthGeneratorNotNullTest() throws Exception {
        LabyrinthGenerator generator = new LabyrinthGenerator();
        Labyrinth labyrinth = generator.generateLabyrinth(10);
        Assert.assertNotNull(labyrinth);
    }

    @Test
    public void SafeRoomPositionTest() throws Exception{
        LabyrinthGenerator generator = new LabyrinthGenerator();
        Labyrinth labyrinth = generator.generateLabyrinth(10);
        Assert.assertTrue(labyrinth.roomIsThere(new RCoordinate(0,0)));
    }

    @Test
    public void LabyrinthGenerationTest() throws Exception {
        LabyrinthGenerator generator = new LabyrinthGenerator();
        Labyrinth labyrinth = generator.generateLabyrinth(20);
        Assert.assertEquals(20, labyrinth.getRoomsNumber());
    }

    @Test
    public void LabyrinthGenerationNotNegativeTest() throws Exception {
        LabyrinthGenerator generator = new LabyrinthGenerator();
        Assert.assertThrows(IllegalArgumentException.class,
                () -> generator.generateLabyrinth(-1));
    }
}
