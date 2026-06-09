package it.sfb.rpg.items.equipment;

import it.sfb.rpg.items.EItemCategory;
import it.sfb.rpg.items.potions.IItem;

public abstract class Armor implements IItem {

    private int healthBuff;
    private String name;
    private final EItemCategory category =  EItemCategory.ARMOR;

    public Armor(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EItemCategory getCategory() {
        return this.category;
    }

    public int getHealthBuff() {
        return healthBuff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthBuff(int healthBuff) {
        this.healthBuff = healthBuff;
    }
}
