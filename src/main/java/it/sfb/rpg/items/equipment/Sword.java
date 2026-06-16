package it.sfb.rpg.items.equipment;

public class Sword extends Weapon {

    private static final int ATTACK_BUFF = 10;

    public Sword(String name) {
        super(name, ATTACK_BUFF);
    }

    @Override
    public String toString() {
        return "Sword";
    }
}
