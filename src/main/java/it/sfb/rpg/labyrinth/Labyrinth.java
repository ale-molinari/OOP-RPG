package it.sfb.rpg.labyrinth;

import java.util.HashMap;

public class Labyrinth {
    private final HashMap<RCoordinate, Room> roomPosition;

    public Labyrinth() {
        roomPosition = new HashMap<>();
    }

    public void addRoom(RCoordinate coordinate, Room room) {
        this.roomPosition.put(coordinate, room);
    }

    public Room getRoomPosition(RCoordinate coordinate) {
        return this.roomPosition.get(coordinate);
    }

    public boolean roomIsThere(RCoordinate coordinate) {
        if (roomPosition.get(coordinate) != null) { }return true;
    }

    public int getRoomsNumber() {
        return this.roomPosition.size();
    }
}
