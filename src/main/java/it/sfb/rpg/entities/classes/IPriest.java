package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

public interface IPriest extends IClass {

    default void damage(IHealth health) {
        int dmg = getAttackValue();
        health.takeDamage(dmg);
    }
    /**
     * Specific method for Priest classes for heal other pgs
     * @param health health of the pg to cure
     */

    default void doSpecialAbility(IHealth health){
        int heal = getAttackValue()*2;
        health.takeDamage(-heal);
    }
}
