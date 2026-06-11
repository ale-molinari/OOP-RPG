package it.sfb.rpg.entities;

import it.sfb.rpg.items.IItem;

public interface IBargain<T extends IItem> {

    T exchange(int currency, T item);
}
