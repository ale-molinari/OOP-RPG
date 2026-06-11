package it.sfb.entities;

import it.sfb.rpg.entities.Merchant;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.items.equipment.*;
import it.sfb.rpg.items.potions.ExpPotion;
import it.sfb.rpg.items.potions.HealPotion;
import it.sfb.rpg.items.potions.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MerchantTest {

    private Merchant<Potion> potionMerchant;
    private Merchant<Weapon> weaponMerchant;
    private Merchant<Armor> armorMerchant;
    private HealPotion healPotion;
    private ExpPotion expPotion;
    private Sword sword;
    private PocketKnife knife;
    private KnightsArmor armor;
    private Tunic tunic;

    @Before
    public void setUp() {
        potionMerchant = new Merchant<>("test 1");
        weaponMerchant = new Merchant<>("test 2");
        armorMerchant = new Merchant<>("test 3");
        healPotion = new HealPotion(10);
        expPotion = new ExpPotion(10);
        sword = new Sword("Weapon 1");
        knife = new PocketKnife("weapon 2");
        armor = new KnightsArmor("armor 1");
        tunic = new Tunic("armor2");
    }

    @Test
    public void potionMerchantInventoryTest() throws Exception {
        potionMerchant.setShop(healPotion, 10);
        potionMerchant.setShop(expPotion, 10);
        Assert.assertEquals(2, potionMerchant.getShop().size());
        Assert.assertTrue(potionMerchant.getShop().containsKey(healPotion));
        Assert.assertTrue(potionMerchant.getShop().containsKey(expPotion));
        Assert.assertEquals(10, potionMerchant.getProductPrice(healPotion));
        Assert.assertEquals(10, potionMerchant.getProductPrice(expPotion));
    }

    @Test
    public void weaponMerchantInventoryTest() throws Exception {
        weaponMerchant.setShop(sword, 10);
        weaponMerchant.setShop(knife, 10);
        Assert.assertEquals(2, weaponMerchant.getShop().size());
        Assert.assertTrue(weaponMerchant.getShop().containsKey(sword));
        Assert.assertTrue(weaponMerchant.getShop().containsKey(knife));
        Assert.assertEquals(10, weaponMerchant.getProductPrice(sword));
        Assert.assertEquals(10, weaponMerchant.getProductPrice(knife));
    }

    @Test
    public void armorMerchantInventoryTest() throws Exception {
        armorMerchant.setShop(armor, 10);
        armorMerchant.setShop(tunic, 10);
        Assert.assertEquals(2, armorMerchant.getShop().size());
        Assert.assertTrue(armorMerchant.getShop().containsKey(armor));
        Assert.assertTrue(armorMerchant.getShop().containsKey(tunic));
        Assert.assertEquals(10, armorMerchant.getProductPrice(armor));
        Assert.assertEquals(10, armorMerchant.getProductPrice(tunic));
    }
}
