package it.sfb.items;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Priest;
import it.sfb.rpg.items.potions.ExpPotion;
import it.sfb.rpg.items.potions.HealPotion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PotionConsumeTest {

    private PlayerCharacter pg;
    private PlayerCharacter pg2;
    private HealPotion estus;
    private ExpPotion soul;

    @Before
    public void setUp() {
        pg = new PlayerCharacter("testCharacter", new Priest(1,20)) {
        };
        pg2 = new PlayerCharacter("pg", new Priest(10,20)) {
        };
        estus = new HealPotion(10);
        soul = new ExpPotion(20);
    }

    @Test
    public void testPotionConsume() {
        pg.getInventory().addItem(estus);
        pg.getInventory().addItem(soul);
        pg2.damage(pg);
        pg.consumeItem(estus);
        pg.consumeItem(soul);
        Assert.assertEquals(20, pg.getHealth());
        Assert.assertEquals(10, pg.getCurrentExperience());
        Assert.assertEquals(2, pg.getLevel());
    }
}
