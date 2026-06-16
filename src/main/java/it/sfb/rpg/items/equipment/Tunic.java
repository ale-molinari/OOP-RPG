package it.sfb.rpg.items.equipment;

public class Tunic extends Armor{

    private static final int HEALTH_BUFF = 5;

    public Tunic(String name) {
        super(name, HEALTH_BUFF);
    }

    @Override
    public String toString() {
        return "Tunic";
    }
}
