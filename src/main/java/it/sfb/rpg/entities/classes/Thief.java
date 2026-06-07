package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Thief extends GameClass implements IThief{

    public Thief(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void damage(IHealth health) {
        IThief.super.damage(health);
    }
}
