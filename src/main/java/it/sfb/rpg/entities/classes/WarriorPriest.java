package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class WarriorPriest extends GameClass implements IWarrior, IPriest {

    public WarriorPriest(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }
    public void damage(IHealth health, boolean mustCure) {
        IPriest.super.damage(health);
    }

    public boolean takeDamage(int dmg) {
        return IWarrior.super.takeDamage(dmg);
    }
}
