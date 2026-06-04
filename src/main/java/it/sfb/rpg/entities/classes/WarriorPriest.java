package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealer;
import it.sfb.rpg.engine.interactions.IHealth;

public class WarriorPriest extends GameClass implements IWarrior, IPriest, IHealer {

    public WarriorPriest(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }
    public void damage(IHealth health) {
        IPriest.super.damage(health);
    }

    public boolean takeDamage(int dmg) {
        return IWarrior.super.takeDamage(dmg);
    }
}
