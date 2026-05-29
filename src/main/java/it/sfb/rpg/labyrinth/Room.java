package it.sfb.rpg.labyrinth;


import java.util.HashMap;
import java.util.UUID;

public abstract class Room {

    private String name;
    private UUID id;
    private RCoordinate coordinate;
    private final HashMap<EDirections, Room> exits;

    public Room(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.exits = new HashMap<>();
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
}
