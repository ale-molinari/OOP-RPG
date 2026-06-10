package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Mage extends GameClass implements IMage{

    public Mage(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void damage(IHealth health) {
        IMage.super.damage(health);
    }

    @Override
    public void doSpecialAbility(IHealth health) {
        IMage.super.doSpecialAbility(health);
    }
}
