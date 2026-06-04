package it.sfb.rpg.entities;

import java.util.UUID;

public class GameCharacter {
    private String name;
    private final UUID id;

    public GameCharacter(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
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
}
