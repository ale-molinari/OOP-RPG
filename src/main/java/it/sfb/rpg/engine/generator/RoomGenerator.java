package it.sfb.rpg.engine.generator;

import it.sfb.rpg.labyrinth.*;

import java.util.ArrayList;

public interface RoomGenerator {

    default ArrayList<Room> roomGenerator(int n) {
        ArrayList<Room> rooms = new ArrayList<>();
        SafeRoom spawnRoom = new SafeRoom("Spawn Room");
        spawnRoom.setCoordinate(new RCoordinate(0,0));
        rooms.add(spawnRoom);
        for (int i = 1; i < n; i++) {
            if (i == n-1) {
                rooms.add(new TreasureRoom("Treasure Room"));
            } else {
                rooms.add(new CombatRoom("Hostile Room"));
            }
        }
        return rooms;
    }
}
