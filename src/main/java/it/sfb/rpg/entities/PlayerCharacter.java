package it.sfb.rpg.entities;

public abstract class PlayerCharacter extends BattleCharacter implements IClass {

    public PlayerCharacter(String name, IClass clz) {
        super(name, clz);
    }
}