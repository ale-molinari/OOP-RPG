package it.sfb.rpg.entities;

import it.sfb.rpg.items.potions.IItem;
import it.sfb.rpg.items.potions.Inventory;
import it.sfb.rpg.items.equipment.Armor;
import it.sfb.rpg.items.equipment.Weapon;

import java.util.List;

public abstract class PlayerCharacter extends BattleCharacter implements IClass {

    public PlayerCharacter(String name, IClass clz) {
        super(name, clz);
    }

    public void changeWeapon(Weapon weapon) {
        this.getInventory().remove(weapon);
        Weapon oldWeapon = this.getEquipment().equipWeapon(weapon);
        if(oldWeapon != null) {
            getInventory().addItem(oldWeapon);
        }
    }

    public void changeArmor(Armor armor) {
        this.getInventory().remove(armor);
        Armor oldArmor = this.getEquipment().equipArmor(armor);
        if(oldArmor != null) {
            getInventory().addItem(oldArmor);
        }
    }

    public void takeLoot(List<IItem> items) {
        for(IItem item : items) {
            if(!this.getInventory().isFull()){
                this.getInventory().addItem(item);
            }
        }
    }
}