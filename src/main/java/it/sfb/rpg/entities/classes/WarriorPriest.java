package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class WarriorPriest extends GameClass implements IWarrior, IPriest {

    public WarriorPriest(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void heal(IHealth health) {
        IPriest.super.heal(health);
    }

    public void damage(IHealth health) {
        IPriest.super.damage(health);
    }

    public boolean takeDamage(int dmg) {
        return IWarrior.super.takeDamage(dmg);
    }
}
