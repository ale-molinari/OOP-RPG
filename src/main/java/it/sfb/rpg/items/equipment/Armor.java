package it.sfb.rpg.items.equipment;

import it.sfb.rpg.items.EItemCategory;

public abstract class Armor implements IEquippable<Armor>, IEnchantable {

    private final int healthBuff;
    private String name;
    private final EItemCategory category =  EItemCategory.ARMOR;
    private int enchantmentBuff;
    private int maxEnchantment;
    private static final int ENCHANT_PRICE = 50;

    public Armor(String name, int healthBuff) {
        this.name = name;
        this.healthBuff = healthBuff;
        this.enchantmentBuff = 0;
        this.maxEnchantment = 5;
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
        return healthBuff + enchantmentBuff;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMaxEnchantment() {
        return maxEnchantment;
    }

    @Override
    public void enchant() {
        this.enchantmentBuff += 2;
        this.maxEnchantment--;
    }

    @Override
    public int getEnchantPrice() {
        return ENCHANT_PRICE;
    }

}
