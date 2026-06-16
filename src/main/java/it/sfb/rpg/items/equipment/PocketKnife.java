package it.sfb.rpg.items.equipment;

public class PocketKnife extends Weapon {

    private static final int ATTACK_BUFF = 5;


    public PocketKnife(String name) {
        super(name, ATTACK_BUFF);
    }

    @Override
    public String toString() {
        return "Pocket Knife";
    }
}
