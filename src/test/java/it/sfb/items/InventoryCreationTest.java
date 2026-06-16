package it.sfb.items;

import it.sfb.rpg.items.EItemCategory;
import it.sfb.rpg.items.IItem;
import it.sfb.rpg.items.equipment.*;
import it.sfb.rpg.items.potions.Inventory;
import it.sfb.rpg.items.potions.ExpPotion;
import it.sfb.rpg.items.potions.HealPotion;
import it.sfb.rpg.items.potions.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class InventoryCreationTest {

    private Inventory<Weapon> weaponInventory;
    private Inventory<Potion> potionInventory;
    private Inventory<IItem> genericInventory;
    private Inventory<Armor> armorInventory;
    private PocketKnife pocketKnife;
    private Sword sword;
    private HealPotion healPotion;
    private ExpPotion expPotion;
    private Tunic tunic;
    private KnightsArmor knightsArmor;

    @Before
    public void setUp() {
        weaponInventory = new Inventory<>();
        potionInventory = new Inventory<>();
        armorInventory = new Inventory<>();
        genericInventory = new Inventory<>();
        pocketKnife = new PocketKnife("knife");
        sword = new Sword("sword");
        healPotion = new HealPotion(20);
        expPotion = new ExpPotion(20);
        tunic = new Tunic("tunic");
        knightsArmor = new KnightsArmor("armor");
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
    public void ArmorInventoryCreationTest() throws Exception {
        armorInventory.addItem(tunic);
        armorInventory.addItem(knightsArmor);
        Assert.assertEquals(2, armorInventory.getItems().size());
        Assert.assertTrue(armorInventory.getItems().contains(tunic));
        Assert.assertTrue(armorInventory.getItems().contains(knightsArmor));
    }

    @Test
    public void GenericInventoryCreationTest() throws Exception {
        genericInventory.addItem(healPotion);
        genericInventory.addItem(pocketKnife);
        Assert.assertEquals(2, genericInventory.getItems().size());
        Assert.assertTrue(genericInventory.getItems().contains(healPotion));
        Assert.assertTrue(genericInventory.getItems().contains(pocketKnife));
    }

    @Test
    public void getItemCategoryTest() throws Exception {
        genericInventory.addItem(healPotion);
        genericInventory.addItem(pocketKnife);
        genericInventory.addItem(tunic);
        List<IItem> weaponInPocket = genericInventory.getByCategory(EItemCategory.WEAPON);
        List<IItem> armorInPocket = genericInventory.getByCategory(EItemCategory.ARMOR);
        List<IItem> potionInPocket = genericInventory.getByCategory(EItemCategory.CONSUMABLE);
        Assert.assertTrue(weaponInPocket.contains(pocketKnife));
        Assert.assertTrue(armorInPocket.contains(tunic));
        Assert.assertTrue(potionInPocket.contains(healPotion));
    }
}
