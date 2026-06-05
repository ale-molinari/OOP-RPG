package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.IStats;

import java.util.Map;

public abstract class PlayerCharacter extends BattleCharacter implements IClass {

    public PlayerCharacter(String name, IClass clz) {
        super(name, clz);
    }
}