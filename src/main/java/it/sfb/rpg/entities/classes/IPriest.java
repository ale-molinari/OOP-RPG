package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

public interface IPriest extends IClass {

    default void damage(IHealth health) {
        int dmg = getAttackValue();
        health.takeDamage(-dmg);
    }
}
