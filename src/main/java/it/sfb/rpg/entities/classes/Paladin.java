package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Paladin extends GameClass implements IWarrior, IPriest {

    public Paladin(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void damage(IHealth health) {
        IPriest.super.damage(health);
    }

    @Override
    public boolean takeDamage(int dmg) {
        return IWarrior.super.takeDamage(dmg);
    }

    @Override
    public void doSpecialAbility(IHealth health) {
        IPriest.super.doSpecialAbility(health);
    }
}
