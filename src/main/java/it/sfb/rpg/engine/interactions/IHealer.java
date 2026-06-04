package it.sfb.rpg.engine.interactions;

import it.sfb.rpg.entities.IClass;

public interface IHealer extends IClass {

    default void heal(IHealth health) {
        int heal = getAttackValue()+getLevel();
        health.takeDamage(-heal);
    }
}
