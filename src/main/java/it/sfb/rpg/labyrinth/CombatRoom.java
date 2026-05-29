package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.GameCharacter;

public class CombatRoom extends Room {
    GameCharacter[] enemies;

    public CombatRoom(String name) {
        super(name);
    }
}
