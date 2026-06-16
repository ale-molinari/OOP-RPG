package it.sfb.rpg.items.equipment;

public class KnightsArmor extends Armor{

    private static final int HEALTH_BUFF = 20;

    public KnightsArmor(String name) {
        super(name, HEALTH_BUFF);
    }

    @Override
    public String toString() {
        return "Knights Armor";
    }

}
