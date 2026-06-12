package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Magus extends GameClass implements IWarrior, IMage {

    public Magus(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public boolean takeDamage(int damage) {
        return IWarrior.super.takeDamage(damage);
    }

    @Override
    public void damage(IHealth health) {
        IMage.super.damage(health);
    }
}
