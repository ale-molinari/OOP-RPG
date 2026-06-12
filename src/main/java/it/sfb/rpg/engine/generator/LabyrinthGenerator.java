package it.sfb.rpg.engine.generator;

import it.sfb.rpg.labyrinth.*;

import java.util.ArrayList;
import java.util.Random;

public class LabyrinthGenerator {

    private final int seed;
    private final Random random;

    public LabyrinthGenerator(int seed) {
        this.seed = seed;
        this.random = new Random(this.seed);
    }

    public LabyrinthGenerator() {
        this.seed = new Random().nextInt();
        this.random = new Random(this.seed);
    }

    /**
     * Procedurally generates a fully connected labyrinth by attaching rooms to
     * randomly chosen available doors on existing rooms.
     * @param numberOfRooms the total number of rooms to place in the map
     * @return the fully generated and connected Labyrinth
     */
    public Labyrinth generateLabyrinth(int numberOfRooms) {

        Labyrinth labyrinth = new Labyrinth();
        ArrayList<Room> rooms = Room.roomGenerator(numberOfRooms);

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

                roomsInTheMap.add(newRoom);

                connectAdjacentRooms(newRoom, labyrinth);
            }
        }
        return labyrinth;
    }

    public int getSeed() {
        return this.seed;
    }

    /**
     * Checks the four cardinal directions around a newly placed room and opens
     * bidirectional doors to any existing adjacent rooms.
     * @param room the newly positioned room on the map
     * @param labyrinth the current state of the map being generated
     */
    private void connectAdjacentRooms(Room room, Labyrinth labyrinth) {

        for (EDirections direction : EDirections.values()) {
            RCoordinate neighborCoordinate = room.getCoordinate().calculateNeighborRoom(direction);
            Room adjacentRoom = labyrinth.getRoomPosition(neighborCoordinate);
            if (adjacentRoom != null) {
                room.setExit(direction, adjacentRoom);
                adjacentRoom.setExit(direction.getOpposite(), room);
            }
        }
    }
}


