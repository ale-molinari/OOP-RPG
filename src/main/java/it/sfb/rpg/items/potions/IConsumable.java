package it.sfb.rpg.items.potions;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.items.IItem;

public interface IConsumable extends IItem {

    void use(PlayerCharacter player);
}
