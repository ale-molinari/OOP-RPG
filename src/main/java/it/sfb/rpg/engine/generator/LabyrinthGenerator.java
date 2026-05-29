package it.sfb.rpg.engine.generator;

import it.sfb.rpg.labyrinth.*;

import java.util.ArrayList;
import java.util.Random;

public class LabyrinthGenerator implements RoomGenerator {

    private int seed;
    private Random random;

    public LabyrinthGenerator(int seed) {
        this.seed = seed;
        this.random = new Random(this.seed);
    }

    public LabyrinthGenerator() {
        this.seed = new Random().nextInt();
        this.random = new Random(this.seed);
    }

    public Labyrinth generateLabyrinth(int numberOfRooms) {

        Labyrinth labyrinth = new Labyrinth();
        ArrayList<Room> rooms = roomGenerator(numberOfRooms);

        Room safeRoom = rooms.removeFirst();
        RCoordinate baseCoordinate = safeRoom.getCoordinate();
        labyrinth.addRoom(baseCoordinate, safeRoom);

        ArrayList<Room> roomsInTheMap = new ArrayList<>();
        roomsInTheMap.add(safeRoom);

        while (!rooms.isEmpty()) {

            int randNum = random.nextInt(roomsInTheMap.size());
            Room nextRoom = roomsInTheMap.get(randNum);

            EDirections[] directions = EDirections.values();
            EDirections direction = directions[random.nextInt(directions.length)];

            if (nextRoom.getExit(direction) != null){
                continue;
            }

            RCoordinate nextCoordinate = nextRoom.getCoordinate().calculateNeighborRoom(direction);

            if (labyrinth.getRoomPosition(nextCoordinate) == null) {

                Room newRoom = rooms.remove(random.nextInt(rooms.size()));
                newRoom.setCoordinate(nextCoordinate);

                labyrinth.addRoom(nextCoordinate, newRoom);
                nextRoom.setExit(direction, newRoom);

                newRoom.setExit(direction.getOpposite(), nextRoom);

                roomsInTheMap.add(newRoom);
            }
        }
        return labyrinth;
    }

    public int getSeed() {
        return this.seed;
    }
}


