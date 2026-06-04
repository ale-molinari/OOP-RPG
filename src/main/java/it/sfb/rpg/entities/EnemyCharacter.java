package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.IHealth;

public abstract class EnemyCharacter extends GameCharacter implements IBattle {

    private IBattle gameClass;

    public EnemyCharacter(String name, IBattle clz) {
        super(name);
        gameClass = clz;
    }

    @Override
    public int getAttackValue() {
        return this.gameClass.getAttackValue();
    }

    @Override
    public void setAttackValue(int attack) {
        this.gameClass.setAttackValue(attack);
    }

    @Override
    public void damage(IHealth health) {
        gameClass.damage(health);
    }

    @Override
    public int getExperienceThreshold() {
        return IBattle.super.getExperienceThreshold();
    }

    @Override
    public int getCurrentExperience() {
        return this.gameClass.getCurrentExperience();
    }

    @Override
    public void setCurrentExperience(int experience) {
        this.gameClass.setCurrentExperience(experience);
    }

    @Override
    public int getLevel() {
        return this.gameClass.getLevel();
    }

    @Override
    public void setLevel(int level) {
        this.gameClass.setLevel(level);
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
        return this.gameClass.getHealth();
    }

    @Override
    public void setHealth(int hp) {
        this.gameClass.setHealth(hp);
    }

    @Override
    public int getCurrentHealth() {
        return this.gameClass.getCurrentHealth();
    }

    @Override
    public void setCurrentHealth(int currentHp) {
        this.gameClass.setCurrentHealth(currentHp);
    }

    @Override
    public boolean takeDamage(int damage) {
        return gameClass.takeDamage(damage);
    }
}
