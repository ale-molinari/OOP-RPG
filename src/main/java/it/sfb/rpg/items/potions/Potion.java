package it.sfb.rpg.items.potions;

import it.sfb.rpg.items.EItemCategory;

public abstract class Potion implements IConsumable {
    private String name;
    private EItemCategory category;

    public Potion(String name) {
        this.name = name;
        this.category = EItemCategory.CONSUMABLE;
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
