package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IBattle;

public interface IPriest extends IBattle {

    default void damage(IHealth health) {
        int dmg = getAttackValue()+getLevel();
        health.takeDamage(-dmg);
    }
}
