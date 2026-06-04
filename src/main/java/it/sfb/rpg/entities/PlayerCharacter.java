package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.labyrinth.Room;

import java.util.UUID;

public abstract class PlayerCharacter extends BattleCharacter implements IBattle {

    public PlayerCharacter(String name, IBattle clz) {
        super(name, clz);
    }
}