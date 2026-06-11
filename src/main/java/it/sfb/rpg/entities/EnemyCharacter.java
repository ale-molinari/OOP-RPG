package it.sfb.rpg.entities;

import it.sfb.rpg.items.IItem;

import java.util.ArrayList;
import java.util.List;

public abstract class EnemyCharacter extends BattleCharacter implements IClass {

    private List<IItem> items = new ArrayList<>();

    public EnemyCharacter(String name, IClass clz) {
        super(name, clz);
    }

    public List<IItem> getItems() {
        return items;
    }

    public void addItem(IItem item) {
        items.add(item);
    }
}
