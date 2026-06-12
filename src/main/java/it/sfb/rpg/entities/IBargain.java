package it.sfb.rpg.entities;

import it.sfb.rpg.items.IItem;

@FunctionalInterface
public interface IBargain<T extends IItem> {

    T exchange(int currency, T item);
}
