package it.sfb.items;

import it.sfb.rpg.items.IItem;
import it.sfb.rpg.items.potions.Inventory;
import it.sfb.rpg.items.equipment.PocketKnife;
import it.sfb.rpg.items.equipment.Sword;
import it.sfb.rpg.items.equipment.Weapon;
import it.sfb.rpg.items.potions.ExpPotion;
import it.sfb.rpg.items.potions.HealPotion;
import it.sfb.rpg.items.potions.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryCreationTest {

    private Inventory<Weapon> weaponInventory;
    private Inventory<Potion> potionInventory;
    private Inventory<IItem> genericInventory;
    private PocketKnife pocketKnife;
    private Sword sword;
    private HealPotion healPotion;
    private ExpPotion expPotion;

    @Before
    public void setUp() {
        weaponInventory = new Inventory<>();
        potionInventory = new Inventory<>();
        genericInventory = new Inventory<>();
        pocketKnife = new PocketKnife("knife");
        sword = new Sword("sword");
        healPotion = new HealPotion(20);
        expPotion = new ExpPotion(20);
    }

    @Test
    public void WeaponInventoryCreationTest() throws Exception {
        weaponInventory.addItem(pocketKnife);
        weaponInventory.addItem(sword);
        Assert.assertEquals(2, weaponInventory.getItems().size());
        Assert.assertTrue(weaponInventory.getItems().contains(sword));
        Assert.assertTrue(weaponInventory.getItems().contains(pocketKnife));
    }

    @Test
    public void PotionInventoryCreationTest() throws Exception{
        potionInventory.addItem(healPotion);
        potionInventory.addItem(expPotion);
        Assert.assertEquals(2, potionInventory.getItems().size());
        Assert.assertTrue(potionInventory.getItems().contains(healPotion));
        Assert.assertTrue(potionInventory.getItems().contains(expPotion));
    }

    @Test
    public void GenericInventoryCreationTest() throws Exception {
        genericInventory.addItem(healPotion);
        genericInventory.addItem(pocketKnife);
        Assert.assertEquals(2, genericInventory.getItems().size());
        Assert.assertTrue(genericInventory.getItems().contains(healPotion));
        Assert.assertTrue(genericInventory.getItems().contains(pocketKnife));
    }
}
