package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

import java.util.Random;

public interface IThief extends IClass {

    default void damage(IHealth health) {
        Random random = new Random();
        int randNum = random.nextInt(100);

        if (randNum <= 25) {
            int dmg = getAttackValue()*2;
            health.takeDamage(dmg);
            return;
        }

        int dmg = getAttackValue();
        health.takeDamage(dmg);
    }
}
