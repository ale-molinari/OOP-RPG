package it.sfb.rpg.items.potions;

import it.sfb.rpg.items.EItemCategory;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends IItem> {

    private ArrayList<T> items;
    private final int maxItems = 10;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        if(items.size() > maxItems) {
            throw new IllegalArgumentException("Inventory full! Cannot add more items!");
        }
        items.add(item);
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void remove(T item) {
        items.remove(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public int getSize() {
        return items.size();
    }

    public boolean isFull() {
        return items.size() == maxItems;
    }

    public List<T> getByCategory(EItemCategory category) {
        List<T> list = new ArrayList<>();
        for(T item : this.items) {
            if(item.getCategory() == category) {
                list.add(item);
            }
        }
        return list;
    }
}
