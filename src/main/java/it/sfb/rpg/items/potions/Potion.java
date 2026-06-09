package it.sfb.rpg.items.potions;

public abstract class Potion implements IConsumable {
    private String name;

    public Potion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
