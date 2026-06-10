package it.sfb.rpg.items.equipment;

public class Tunic extends Armor{

    private final int healthBuff = 5;

    public Tunic(String name) {
        super(name);
        this.setHealthBuff(healthBuff);
    }

    @Override
    public String toString() {
        return "Tunic";
    }
}
