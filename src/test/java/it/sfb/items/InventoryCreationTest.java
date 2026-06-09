package it.sfb.items;

import it.sfb.rpg.items.potions.IItem;
import it.sfb.rpg.items.potions.Inventory;
import it.sfb.rpg.items.equipment.PocketKnife;
import it.sfb.rpg.items.equipment.Sword;
import it.sfb.rpg.items.equipment.Weapon;
import it.sfb.rpg.items.potions.ExpPotion;
import it.sfb.rpg.items.potions.HealPotion;
import it.sfb.rpg.items.potions.Potion;
import org.junit.Assert;
import org.junit.Test;

public class InventoryCreationTest {

    @Test
    public void WeaponInventoryCreationTest() throws Exception {
        Inventory<Weapon> inventory = new Inventory<>();
        PocketKnife pocketKnife = new PocketKnife("knife");
        Sword sword = new Sword("sword");
        inventory.addItem(pocketKnife);
        inventory.addItem(sword);
        Assert.assertEquals(2, inventory.getItems().size());
        Assert.assertTrue(inventory.getItems().contains(sword));
        Assert.assertTrue(inventory.getItems().contains(pocketKnife));
    }

    @Test
    public void PotionInventoryCreationTest() throws Exception{
        Inventory<Potion> inventory = new Inventory<>();
        HealPotion healPotion = new HealPotion(20);
        ExpPotion expPotion = new ExpPotion(20);
        inventory.addItem(healPotion);
        inventory.addItem(expPotion);
        Assert.assertEquals(2, inventory.getItems().size());
        Assert.assertTrue(inventory.getItems().contains(healPotion));
        Assert.assertTrue(inventory.getItems().contains(expPotion));
    }

    @Test
    public void GenericInventoryCreationTest() throws Exception {
        Inventory<IItem>  inventory = new Inventory<>();
        HealPotion healPotion = new HealPotion(20);
        PocketKnife pocketKnife = new PocketKnife("knife");
        inventory.addItem(healPotion);
        inventory.addItem(pocketKnife);
        Assert.assertEquals(2, inventory.getItems().size());
        Assert.assertTrue(inventory.getItems().contains(healPotion));
        Assert.assertTrue(inventory.getItems().contains(pocketKnife));
    }
}
