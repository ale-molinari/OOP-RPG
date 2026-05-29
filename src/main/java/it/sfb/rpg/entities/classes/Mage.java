package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.Role;

public class Mage extends Role {


    public Mage(String name, int attack, int health) {
        super(name, attack, health);
    }

    @Override
    public void damage(IHealth health) {
        health.takeDamage(getAttackValue() + getLevel());
    }

}
