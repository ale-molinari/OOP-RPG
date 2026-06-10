package it.sfb.items;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Warrior;
import it.sfb.rpg.items.equipment.KnightsArmor;
import it.sfb.rpg.items.equipment.Tunic;
import org.junit.Assert;
import org.junit.Test;

public class ArmorWearBuffTest {

    @Test
    public void ArmorWearHealthBuffTest() {
        PlayerCharacter pg = new PlayerCharacter("testcharacter", new Warrior(10, 10)) {
        };
        KnightsArmor armor = new KnightsArmor("knights armor");
        Tunic tunic = new Tunic("tunic");
        pg.getInventory().addItem(armor);
        pg.getInventory().addItem(tunic);
        pg.changeEquipment(armor);
        Assert.assertEquals(30, pg.getHealth());
        pg.changeEquipment(tunic);
        Assert.assertEquals(15, pg.getHealth());
    }
}
