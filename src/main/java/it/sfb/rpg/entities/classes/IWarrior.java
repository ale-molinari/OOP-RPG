package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

public interface IWarrior extends IClass {

    default boolean takeDamage(int damage) {
        if (damage < 0) {
            return IClass.super.takeDamage(damage);
        }
        return IClass.super.takeDamage(Math.clamp(damage-getLevel(), 0, damage));
    }

    /**
     * Special method for Warrior. It does self-attack value x self-level damage
     * @param health target hp
     */
    default void doSpecialAbility(IHealth health) {
        int dmg = getAttackValue()*getLevel();
        health.takeDamage(dmg);
    }

}
