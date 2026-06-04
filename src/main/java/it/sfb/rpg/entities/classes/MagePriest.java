package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class MagePriest extends GameClass implements IMage, IPriest {

    public MagePriest(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void damage(IHealth health) {
        IMage.super.damage(health);
        setHealth(getCurrentHealth() + (getAttackValue()/2));
    }

    @Override
    public void heal(IHealth health) {
        IPriest.super.heal(health);
    }
}
