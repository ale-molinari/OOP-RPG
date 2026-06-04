package it.sfb.rpg.labyrinth;

import java.util.HashMap;

public class Labyrinth {
    private final HashMap<RCoordinate, Room> map;

    public Labyrinth() {
        map = new HashMap<>();
    }

    public void addRoom(RCoordinate coordinate, Room room) {
        this.map.put(coordinate, room);
    }

    public Room getRoomPosition(RCoordinate coordinate) {
        return this.map.get(coordinate);
    }

    public boolean roomIsThere(RCoordinate coordinate) {
        return map.containsKey(coordinate);
    }

    public int getRoomsNumber() {
        return this.map.size();
    }

    public HashMap<RCoordinate, Room> getMap() {
        return map;
    }
}
