package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

public interface IMage extends IClass {

    default void damage(IHealth health) {
        int dmg = getAttackValue()+getLevel();
        health.takeDamage(dmg);
    }

    /**
     * Special method for Mage. It steals life from a target and takes it.
     * @param health target hp.
     */
    default void doSpecialAbility(IHealth health){
        int lifeSteal = getCurrentHealth()/2;
        health.takeDamage(lifeSteal);
        int newLife = Math.clamp(getCurrentHealth()+lifeSteal, getCurrentHealth(), getHealth());
        setCurrentHealth(newLife);
    }
}
