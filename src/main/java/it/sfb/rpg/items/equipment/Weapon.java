package it.sfb.rpg.items.equipment;

import it.sfb.rpg.items.EItemCategory;
import it.sfb.rpg.items.potions.IItem;

public abstract class Weapon implements IItem {

    private String name;
    private int attackBuff;
    private final EItemCategory category = EItemCategory.WEAPON;

    public Weapon(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EItemCategory getCategory() {
        return category;
    }

    public int getAttackBuff() {
        return attackBuff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackBuff(int attackBuff) {
        this.attackBuff = attackBuff;
    }
}
