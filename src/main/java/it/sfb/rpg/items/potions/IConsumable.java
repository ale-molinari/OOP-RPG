package it.sfb.rpg.items.potions;

import it.sfb.rpg.entities.PlayerCharacter;

public interface IConsumable extends IItem {

    void use(PlayerCharacter player);
}
