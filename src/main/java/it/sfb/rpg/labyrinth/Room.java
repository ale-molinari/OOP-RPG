package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.labyrinth.events.CombatEvent;
import it.sfb.rpg.labyrinth.events.HealEvent;
import it.sfb.rpg.labyrinth.events.RewardEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public abstract class Room {

    private String name;
    private UUID id;
    private RCoordinate coordinate;
    private final HashMap<EDirections, Room> exits;
    private IGameEvent event;

    public Room(String name, IGameEvent evnt) {
        this.name = name;
        event = evnt;
        this.id = UUID.randomUUID();
        exits = new HashMap<>();
    }

    public Room getExit(EDirections direction) {
        return exits.get(direction);
    }

    public void setExit(EDirections direction, Room neighborRoom) {
        exits.put(direction, neighborRoom);
    }

    public RCoordinate getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(RCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Set<EDirections> getAvailableDirections() {
        return exits.keySet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public IGameEvent getEvent() {
        return this.event;
    }

    public void triggerEvent(PlayerCharacter player) {
        if (this.event != null) {
            this.event.triggerEvent(player);
        }
    }

    public abstract String getSymbol();

    public static ArrayList<Room> roomGenerator(int n) {

        int roomAmount = Math.clamp(n, 0, 20);
        ArrayList<Room> rooms = new ArrayList<>();

        if (roomAmount > 0) {
            SafeRoom spawnRoom = new SafeRoom("Spawn Room", new HealEvent());
            spawnRoom.setCoordinate(new RCoordinate(0, 0));
            rooms.add(spawnRoom);
        } else {
            throw new IllegalArgumentException("Room amount must be greater than 0");
        }

        for (int i = 1; i < roomAmount; i++) {
            if (i == roomAmount-1) {
                rooms.add(new TreasureRoom("Treasure Room", new RewardEvent()));
            } else {
                rooms.add(new CombatRoom("Hostile Room", new CombatEvent()));
            }
        }

        return rooms;
    }
}
