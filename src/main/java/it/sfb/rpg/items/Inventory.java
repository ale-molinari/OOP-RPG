package it.sfb.rpg.items;

import java.util.ArrayList;

public class Inventory<T extends IItem> {

    private ArrayList<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public int getSize() {
        return items.size();
    }
}
