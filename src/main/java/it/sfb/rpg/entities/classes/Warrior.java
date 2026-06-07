package it.sfb.rpg.entities.classes;

public class Warrior extends GameClass implements IWarrior{

    public Warrior(int startingAttack, int startingHealth) {
        super(startingAttack, startingHealth);
    }

    @Override
    public boolean takeDamage(int damage) {
        return IWarrior.super.takeDamage(damage);
    }
}
