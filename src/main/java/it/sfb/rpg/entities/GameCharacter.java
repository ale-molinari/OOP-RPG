package it.sfb.rpg.entities;

import java.util.UUID;

public abstract class GameCharacter {
    private final Role role;

    public GameCharacter(Role role) {
        this.role = role;
    }
    public int getHealth() {
        return role.getHealth();
    }
    public void setHealth(int health) {
        role.setHealth(health);
    }
    public int getAttackValue(){
        return role.getAttackValue();
    }
    public void setAttackValue(int attack) {
        role.setAttackValue(attack);
    }
    public int getCurrentHealth() {
        return role.getCurrentHealth();
    }
    public void setCurrentHealth(int currentHealth) {
        role.setCurrentHealth(currentHealth);
    }
    public int getCurrentExperience() {
        return role.getCurrentExperience();
    }

    public void setCurrentExperience(int experience) {
        role.setCurrentExperience(experience);
    }

    public int getLevel() {
        return role.getLevel();
    }

    public void setLevel(int level) {
        role.setLevel(level);
    }

    public Role getRole() {
        return role;
    }
}
