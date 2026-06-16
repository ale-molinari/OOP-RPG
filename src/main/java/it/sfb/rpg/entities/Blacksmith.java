package it.sfb.rpg.entities;


import it.sfb.rpg.items.equipment.IEnchantable;



import java.util.HashMap;
import java.util.Map;

public class Blacksmith extends PngCharacter {

    private boolean isWorking;

    public Blacksmith(String name) {
        super(name);
        this.isWorking = true;
    }

    public void setWorking(boolean working) {
        this.isWorking = working;
    }

    public void buffEquipment(PlayerCharacter player, IEnchantable item) {

        if( !isWorking) {
            System.out.println("Blacksmith is not working");
        }

        if (item.getMaxEnchantment() != 0 && player.getGold() >= item.getEnchantPrice()) {
            player.setGold(player.getGold() - item.getEnchantPrice());
            item.enchant();
        } else {
            System.out.println("You can't enchant this item");
        }
    }

    @Override
    public String talk() {
        return "I'm working till the end of times...";
    }
}
