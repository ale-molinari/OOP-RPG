package it.sfb.rpg.entities;

import it.sfb.rpg.items.IItem;

import java.util.HashMap;
import java.util.Map;

public class Merchant<T extends IItem> extends PngCharacter implements IBargain<T> {

    private Map<IItem, Integer> shop;
    private int wallet;

    public Merchant(String name) {
        super(name);
        this.shop = new HashMap<>();
        this.wallet = 0;
    }

    public Map<IItem, Integer> getShop() {
        return shop;
    }

    public void setShop(IItem item, int price) {
        this.shop.put(item, price);
    }

    public int getProductPrice(IItem item) {
        return shop.getOrDefault(item, 0);
    }

    public boolean getItem(IItem item){
        return shop.containsKey(item);
    }

    public int getWallet() {
        return wallet;
    }

    @Override
    public String talk() {
        return "Hello adventurer, I'm a merchant. I may have something interesting for you.";
    }

    @Override
    public String toString() {
        return "Merchant";
    }

    @Override
    public T exchange(int currency, T item) {

        if (!shop.containsKey(item)) {
            System.out.println("Sorry, I don't have that item.");
            return null;
        }

        int price = getProductPrice(item);

        if (currency >= price) {
            shop.remove(item);
            wallet += price;
            System.out.println("You bought " + item.getName() + " for " + price + " gold.");
            return item;
        } else {
            System.out.println("You don't have enough money.");
            return null;
        }
    }
}
