package it.sfb.items;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Warrior;
import it.sfb.rpg.items.equipment.KnightsArmor;
import it.sfb.rpg.items.equipment.Tunic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArmorWearBuffTest {

    private PlayerCharacter pg;
    private KnightsArmor armor;
    private Tunic tunic;

    @Before
    public void setUp() {
        pg = new PlayerCharacter("test character", new Warrior(10, 10)) {
        };
        armor = new KnightsArmor("knights armor");
        tunic = new Tunic("tunic");
    }

    @Test
    public void ArmorWearHealthBuffTest() {
        pg.getInventory().addItem(armor);
        pg.getInventory().addItem(tunic);
        pg.changeEquipment(armor);
        Assert.assertEquals(30, pg.getHealth());
        pg.changeEquipment(tunic);
        Assert.assertEquals(15, pg.getHealth());
    }
}
