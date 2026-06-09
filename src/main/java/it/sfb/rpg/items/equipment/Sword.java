package it.sfb.rpg.items.equipment;

import it.sfb.rpg.entities.BattleCharacter;
import it.sfb.rpg.entities.PlayerCharacter;

public class Sword extends Weapon {

    private final int damage = 10;

    public Sword(String name) {
        super(name);
        this.setAttackBuff(damage);
    }
}
