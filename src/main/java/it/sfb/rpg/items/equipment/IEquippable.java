package it.sfb.rpg.items.equipment;

import it.sfb.rpg.items.IItem;

/**
 * Generic interface for any item that can be equipped by a character.
 * Uses a self-bound generic type to ensure type safety during equipping.
 * @param <T> the concrete type implementing this interface
 */
public interface IEquippable<T extends IEquippable<T>> extends IItem {

    /**
     * Double dispatch method to equip the item into the correct manager slot.
     * @param manager the equipment manager to dispatch the item to
     * @return the old item of the same type that was replaced or null
     */
    T equipOn(EquipmentManager manager);
}
