package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.Role;

public class Priest extends Role {


    public Priest(String name, int attack, int health) {
        super(name, attack, health);
    }

    /**
     * A priest heals for attack+level
     * @param health health interface to take dmg
     */
    @Override
    public void damage(IHealth health) {
        int dmg = getAttackValue()+getLevel();
        health.takeDamage(-dmg);
    }

}
