package it.sfb.rpg.entities;

import it.sfb.rpg.items.potions.IConsumable;
import it.sfb.rpg.items.potions.IItem;
import it.sfb.rpg.items.equipment.Armor;
import it.sfb.rpg.items.equipment.Weapon;

import java.util.List;

public abstract class PlayerCharacter extends BattleCharacter implements IClass {

    public PlayerCharacter(String name, IClass clz) {
        super(name, clz);
    }

    public void equipWeapon(Weapon weapon) {

    }

    public void changeWeapon(Weapon weapon) {
        if (this.getInventory().remove(weapon)) {
            Weapon oldWeapon = this.getEquipment().equipWeapon(weapon);
            if (oldWeapon != null) {
                getInventory().addItem(oldWeapon);
            }
        } else {
            System.out.println("Item not found");
        }

    }

    public void changeArmor(Armor armor) {
        if (this.getInventory().remove(armor)) {
            Armor oldArmor = this.getEquipment().equipArmor(armor);
            if (oldArmor != null) {
                getInventory().addItem(oldArmor);
            }
        } else {
            System.out.println("Item not found");
        }
    }


    public void takeLoot(List<IItem> items) {
        for(IItem item : items) {
            if(!this.getInventory().isFull()){
                this.getInventory().addItem(item);
            }
        }
    }

    public boolean consumeItem(IConsumable consumable) {
        if (this.getInventory().remove(consumable)) {
            consumable.use(this);
            return true;
        }
        return false;
    }
}