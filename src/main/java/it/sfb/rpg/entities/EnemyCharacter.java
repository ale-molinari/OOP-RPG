package it.sfb.rpg.entities;

import it.sfb.rpg.items.potions.IItem;

import java.util.ArrayList;
import java.util.List;

public abstract class EnemyCharacter extends BattleCharacter implements IClass {

    public EnemyCharacter(String name, IClass clz) {
        super(name, clz);
    }
}
