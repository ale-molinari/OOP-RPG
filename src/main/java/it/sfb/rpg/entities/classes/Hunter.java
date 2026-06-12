package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Hunter extends GameClass implements IWarrior, IThief {

    public Hunter(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public boolean takeDamage(int damage) {
        return IWarrior.super.takeDamage(damage);
    }

    @Override
    public void doSpecialAbility(IHealth health) {
        IThief.super.doSpecialAbility(health);
    }
}

