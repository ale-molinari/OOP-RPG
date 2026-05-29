package it.sfb.rpg.entities.classes;

import it.sfb.rpg.entities.Role;

public class Warrior extends Role {


    public Warrior(String name, int attack, int health) {
        super(name, attack, health);
    }

    @Override
    public boolean takeDamage(int damage) {
        return super.takeDamage(Math.clamp(damage-getLevel(), 0, damage));
    }

}
