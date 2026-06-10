package it.sfb.rpg.items.equipment;

import it.sfb.rpg.entities.classes.Warrior;

public class PocketKnife extends Weapon {

    private final int damage = 5;

    public PocketKnife(String name) {
        super(name);
        this.setAttackBuff(damage);
    }

    @Override
    public String toString() {
        return "Pocket Knife";
    }
}
