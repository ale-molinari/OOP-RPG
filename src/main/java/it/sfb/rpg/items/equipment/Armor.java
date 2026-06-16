package it.sfb.rpg.items.equipment;

import it.sfb.rpg.items.EItemCategory;

public abstract class Armor implements IEquippable<Armor> {

    private int healthBuff;
    private String name;
    private final EItemCategory category =  EItemCategory.ARMOR;

    public Armor(String name, int healthBuff) {
        this.name = name;
        this.healthBuff = healthBuff;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EItemCategory getCategory() {
        return this.category;
    }

    /**
     * Enters the armor slot of the equipment manager.
     * @param manager the manager handling the equipment
     * @return the previously equipped armor, or null
     */
    @Override
    public Armor equipOn(EquipmentManager manager){
        return manager.equipArmor(this);
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
