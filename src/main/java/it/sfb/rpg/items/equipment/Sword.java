package it.sfb.rpg.items.equipment;

public class Sword extends Weapon {

    private final int damage = 10;

    public Sword(String name) {
        super(name);
        this.setAttackBuff(damage);
    }

    @Override
    public String toString() {
        return "Sword";
    }
}
