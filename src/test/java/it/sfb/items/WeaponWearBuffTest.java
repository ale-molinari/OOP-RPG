package it.sfb.items;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Priest;
import it.sfb.rpg.items.equipment.PocketKnife;
import org.junit.Assert;
import org.junit.Test;

public class WeaponWearBuffTest {

    @Test
    public void PocketKnifeBuffTest() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("test character", new Priest(10, 10)) {
        };
        PocketKnife knife = new PocketKnife("pocket knife");
        pg.getInventory().addItem(knife);
        pg.changeWeapon(knife);
        Assert.assertEquals(15, pg.getAttackValue());
    }
}
