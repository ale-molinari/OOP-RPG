package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class WarriorThief extends GameClass implements IWarrior, IThief {

    public WarriorThief(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public boolean takeDamage(int damage) {
        return IWarrior.super.takeDamage(damage);
    }

    @Override
    public void damage(IHealth health) {
        IThief.super.damage(health);
    }
}

