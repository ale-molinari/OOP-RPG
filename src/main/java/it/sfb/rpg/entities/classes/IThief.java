package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

import java.util.Random;

public interface IThief extends IClass {

    /**
     * Specific method for thief. It allows doing 2x damage or /2 depending on a random number
     * @param health target hp
     */
    default void doSpecialAbility(IHealth health) {
        Random random = new Random();
        int randNum = random.nextInt(100);

        if (randNum <= 50) {
            int dmg = getAttackValue()*2;
            health.takeDamage(dmg);
            return;
        }

        int dmg = getAttackValue()/2;
        health.takeDamage(dmg);
    }
}
