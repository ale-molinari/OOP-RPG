package it.sfb.rpg.items.potions;

import it.sfb.rpg.items.EItemCategory;

public abstract class Potion implements IConsumable {
    private final String name;
    private final EItemCategory category = EItemCategory.CONSUMABLE;

    public Potion(String name) {
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
}
