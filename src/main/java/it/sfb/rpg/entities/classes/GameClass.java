package it.sfb.rpg.entities.classes;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.IBattle;

public class GameClass implements IBattle {

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
        IBattle.super.damage(health);
    }

    @Override
    public int getExperienceThreshold() {
        return IBattle.super.getExperienceThreshold();
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
        IBattle.super.gainExperience(experience);
    }

    @Override
    public void levelUp() {
        IBattle.super.levelUp();
    }

    @Override
    public boolean isAlive() {
        return IBattle.super.isAlive();
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
        return IBattle.super.takeDamage(damage);
    }
}
