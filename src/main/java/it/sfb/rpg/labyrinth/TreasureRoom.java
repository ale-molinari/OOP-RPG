package it.sfb.rpg.labyrinth;

import it.sfb.rpg.items.potions.IItem;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom extends Room {
    private final List<IItem> items;

    public TreasureRoom(String name, IGameEvent evnt) {
        super(name, evnt);
        this.items = new ArrayList<>();
    }

    public void addItem(IItem item) {
        items.add(item);
    }

    public List<IItem> getItems() {
        return items;
    }

    @Override
    public String getSymbol() {
        return "[T]";
    }
}
