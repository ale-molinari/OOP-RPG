package it.sfb.rpg.items.equipment;

import it.sfb.rpg.entities.BattleCharacter;
import it.sfb.rpg.items.IItem;

public interface IWearable extends IItem {
    void wearBy(BattleCharacter pg);
}
