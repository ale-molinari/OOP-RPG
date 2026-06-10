package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;

public class Warrior extends GameClass implements IWarrior{

    public Warrior(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public boolean takeDamage(int damage) {
        return IWarrior.super.takeDamage(damage);
    }

    @Override
    public void doSpecialAbility(IHealth health) {
        IWarrior.super.doSpecialAbility(health);
    }
}
