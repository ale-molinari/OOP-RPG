package it.sfb.rpg.items.equipment;

public class EquipmentSlot<T> {

    private T item;

    public EquipmentSlot(){
        this.item = null;
    }

    public T getItem(){
        return item;
    }

    public void setItem(T item){
        this.item = item;
    }

    public boolean isEmpty(){
        return this.item == null;
    }

    public void clear(){
        this.item = null;
    }
}
