package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IClass;

public class GameClass implements IClass {

    private int attack;
    private int health;
    private int currentHealth;
    private int level;
    private int currentExperience;

    public GameClass(int startingAttack, int startingHealth) {
        this.attack = startingAttack;
        this.health = startingHealth;
        this.currentHealth = startingHealth;
        this.level = 1;
        this.currentExperience = 0;
    }

    @Override
    public int getAttackValue() {
        return this.attack;
    }

    @Override
    public void setAttackValue(int attack) {
        this.attack = attack;
    }

    @Override
    public void damage(IHealth health) {
        IClass.super.damage(health);
    }

    @Override
    public int getExperienceThreshold() {
        return IClass.super.getExperienceThreshold();
    }

    @Override
    public int getCurrentExperience() {
        return this.currentExperience;
    }

    @Override
    public void setCurrentExperience(int experience) {
        this.currentExperience = experience;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void gainExperience(int experience) {
        IClass.super.gainExperience(experience);
    }

    @Override
    public void levelUp() {
        IClass.super.levelUp();
    }

    @Override
    public boolean isAlive() {
        return IClass.super.isAlive();
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int hp) {
        this.health = hp;
    }

    @Override
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    @Override
    public void setCurrentHealth(int currentHp) {
        this.currentHealth = currentHp;
    }

    @Override
    public boolean takeDamage(int damage) {
        return IClass.super.takeDamage(damage);
    }

    @Override
    public void heal(IHealth health) {
        System.out.println("You can't heal nobody");
    }
}
