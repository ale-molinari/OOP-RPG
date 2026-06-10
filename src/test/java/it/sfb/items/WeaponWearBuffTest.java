package it.sfb.items;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Priest;
import it.sfb.rpg.items.equipment.PocketKnife;
import it.sfb.rpg.items.equipment.Sword;
import org.junit.Assert;
import org.junit.Test;

public class WeaponWearBuffTest {

    @Test
    public void PocketKnifeBuffTest() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("test character", new Priest(10, 10)) {
        };
        PocketKnife knife = new PocketKnife("pocket knife");
        pg.getInventory().addItem(knife);
        pg.changeEquipment(knife);
        Assert.assertEquals(15, pg.getAttackValue());
    }

    @Test
    public void SwordBuffTest() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("test character", new Priest(10, 10)) {
        };
        Sword sword = new Sword("sword");
        pg.getInventory().addItem(sword);
        pg.changeEquipment(sword);
        Assert.assertEquals(20, pg.getAttackValue());
    }

    @Test
    public void WeaponSwitchTest() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("test character", new Priest(10, 10)) {
        };
        PocketKnife knife = new PocketKnife("pocket knife");
        Sword sword = new Sword("sword");
        pg.getInventory().addItem(knife);
        pg.changeEquipment(knife);
        Assert.assertEquals(15, pg.getAttackValue());
        pg.getInventory().addItem(sword);
        pg.changeEquipment(sword);
        Assert.assertEquals(20, pg.getAttackValue());
    }
}
