package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealer;
import it.sfb.rpg.engine.interactions.IHealth;

public class Priest extends GameClass implements IPriest {

    private int healingPower;

    public Priest(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
        this.healingPower = 2;
    }

    @Override
    public void damage(IHealth health) {
        IPriest.super.damage(health);
    }
}
