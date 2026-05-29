package it.sfb.rpg.entities;

public abstract class Role implements IBattle {

    private String name;
    private int attack;
    private int health;
    private int currentHealth;
    private int experience;
    private int level;

    public Role(String name, int attack, int health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.currentHealth = health;
        this.experience = 0;
        this.level = 1;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public int getAttackValue(){
        return attack;
    }
    @Override
    public void setAttackValue(int attack) {
        this.attack = attack;
    }
    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }
    @Override
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    @Override
    public int getCurrentExperience() {
        return experience;
    }

    @Override
    public void setCurrentExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



