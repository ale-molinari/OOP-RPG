package it.sfb.rpg.items.equipment;

public abstract class Armor implements IWearable{

    private int healthBuff;
    private String name;

    public Armor(String name, int healthBuff) {
        this.name = name;
        this.healthBuff = healthBuff;
    }

    public int getHealthBuff() {
        return healthBuff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthBuff(int healthBuff) {
        this.healthBuff = healthBuff;
    }
}
