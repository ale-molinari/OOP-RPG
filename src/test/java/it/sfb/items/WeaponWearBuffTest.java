package it.sfb.items;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Priest;
import it.sfb.rpg.items.equipment.PocketKnife;
import it.sfb.rpg.items.equipment.Sword;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeaponWearBuffTest {

    private PlayerCharacter pg;
    private PocketKnife knife;
    private Sword sword;

    @Before
    public void setUp() {
        pg = new PlayerCharacter("test character", new Priest(10, 10)) {};
        knife = new PocketKnife("knife");
        sword = new Sword("sword");
    }

    @Test
    public void PocketKnifeBuffTest() throws Exception {
        pg.getInventory().addItem(knife);
        pg.changeEquipment(knife);
        Assert.assertEquals(15, pg.getAttackValue());
    }

    @Test
    public void SwordBuffTest() throws Exception {
        pg.getInventory().addItem(sword);
        pg.changeEquipment(sword);
        Assert.assertEquals(20, pg.getAttackValue());
    }

    @Test
    public void WeaponSwitchTest() throws Exception {
        pg.getInventory().addItem(knife);
        pg.changeEquipment(knife);
        Assert.assertEquals(15, pg.getAttackValue());
        pg.getInventory().addItem(sword);
        pg.changeEquipment(sword);
        Assert.assertEquals(20, pg.getAttackValue());
    }
}
