package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IBattle;

public interface IPriest extends IBattle {

    default void damage(IHealth health) {
        int dmg = getAttackValue();
        health.takeDamage(dmg);
    }

    default void heal(IHealth health) {
        int heal = getAttackValue()+getLevel();
        health.takeDamage(-heal);
    }
}
