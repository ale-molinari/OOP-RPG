package it.sfb.rpg.entities;

import java.util.UUID;

public class PlayerCharacter extends GameCharacter {

    private final UUID id;

    public PlayerCharacter(Role role) {
        super(role);
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }
}