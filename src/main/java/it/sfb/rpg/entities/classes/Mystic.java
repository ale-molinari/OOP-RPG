package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Mystic extends GameClass implements IMage, IPriest {

    public Mystic(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public void damage(IHealth health) {
        IMage.super.damage(health);
    }

    @Override
    public void doSpecialAbility(IHealth health) {
        IPriest.super.doSpecialAbility(health);
    }
}
