package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class WarriorPriest extends GameClass implements IWarrior, IPriest {

    public WarriorPriest(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void damage(IHealth health) {
        IPriest.super.damage(health);
    }
}
