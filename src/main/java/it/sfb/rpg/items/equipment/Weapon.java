package it.sfb.rpg.items.equipment;

import it.sfb.rpg.entities.BattleCharacter;

public abstract class Weapon implements IWearable{

    private String name;
    private int attackBuff;

    public Weapon(String name, int attackBuff) {
        this.name = name;
        this.attackBuff = attackBuff;
    }

    public String getName() {
        return name;
    }

    public int getAttackBuff() {
        return attackBuff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackBuff(int attackBuff) {
        this.attackBuff = attackBuff;
    }

    @Override
    public void wearBy(BattleCharacter pg) {
        pg.setAttackValue(pg.getAttackValue() + getAttackBuff());
    }
}
