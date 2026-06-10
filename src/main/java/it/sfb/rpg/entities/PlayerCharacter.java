package it.sfb.rpg.entities;

import it.sfb.rpg.items.equipment.IEquippable;
import it.sfb.rpg.items.potions.IConsumable;
import it.sfb.rpg.items.potions.IItem;

import java.util.List;

public abstract class PlayerCharacter extends BattleCharacter implements IClass {

    public PlayerCharacter(String name, IClass clz) {
        super(name, clz);
    }

    /**
     * Changes the character's current equipment with a new item from the inventory.
     * Uses double dispatch to dynamically route the item to its correct slot,
     * and automatically places any unequipped old item back into the inventory.
     * @param <T> the type of the equippable item, self-bounded to guarantee type safety
     * @param item the equippable item to be taken from the inventory and put on
     */
    public <T extends IEquippable<T>> void changeEquipment(T item) {
        if (this.getInventory().remove(item)) {
            T oldItem = item.equipOn(this.getEquipment());
            if (oldItem != null) {
                getInventory().addItem(oldItem);
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