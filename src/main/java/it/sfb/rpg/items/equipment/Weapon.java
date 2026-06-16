package it.sfb.rpg.items.equipment;

import it.sfb.rpg.items.EItemCategory;

public abstract class Weapon implements IEquippable<Weapon>, IEnchantable {

    private String name;
    private final int attackBuff;
    private final EItemCategory category = EItemCategory.WEAPON;
    private int enchantmentBuff;
    private int maxEnchantment;
    private static final int ENCHANT_PRICE = 100;

    public Weapon(String name, int attackBuff) {
        this.name = name;
        this.attackBuff = attackBuff;
        this.enchantmentBuff = 0;
        this.maxEnchantment = 10;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EItemCategory getCategory() {
        return category;
    }

    /**
     * Enters the weapon slot of the equipment manager.
     * @param manager the manager handling the equipment
     * @return the previously equipped weapon, or null
     */
    @Override
    public Weapon equipOn(EquipmentManager manager){
        return manager.equipWeapon(this);
    }

    public int getAttackBuff() {
        return attackBuff + enchantmentBuff;
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
        this.enchantmentBuff += 3;
        this.maxEnchantment--;
    }

    @Override
    public int getEnchantPrice() {
        return ENCHANT_PRICE;
    }
}
