package it.sfb.rpg.entities.classes;

import it.sfb.rpg.entities.IBattle;

public interface IWarrior extends IBattle {

    default boolean takeDamage(int damage) {
        if (damage < 0) {
            return IBattle.super.takeDamage(damage);
        }
        return IBattle.super.takeDamage(Math.clamp(damage-getLevel(), 0, damage));
    }

}
