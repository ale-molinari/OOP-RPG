package it.sfb.rpg.items.equipment;

public class KnightsArmor extends Armor{

    private final int healthBuff = 20;

    public KnightsArmor(String name) {
        super(name);
        this.setHealthBuff(healthBuff);
    }

    @Override
    public String toString() {
        return "Knights Armor";
    }

}
