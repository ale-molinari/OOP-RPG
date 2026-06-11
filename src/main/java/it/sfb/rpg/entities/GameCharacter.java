package it.sfb.rpg.entities;

import it.sfb.rpg.items.IItem;
import it.sfb.rpg.items.potions.Inventory;

import java.util.UUID;

public class GameCharacter {

    private String name;
    private final UUID id;
    private Inventory<IItem> inventory;

    public GameCharacter(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.inventory = new Inventory<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Inventory<IItem> getInventory() {
        return inventory;
    }
}
