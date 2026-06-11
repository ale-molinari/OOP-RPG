package it.sfb.entities;

import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.*;
import org.junit.Assert;
import org.junit.Test;

public class CharactersInteractionsTests {

    @Test
    public void testWarriorMageDefense() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(5, 10)) {
        };
        EnemyCharacter pg2 = new EnemyCharacter("enemy", new WarriorMage(1, 10)) {
        };
        pg.damage(pg2);
        Assert.assertEquals(5, pg2.getCurrentHealth());
    }

    @Test
    public void testWarriorPriestDefense() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorPriest(4, 10)) {
        };
        EnemyCharacter pg2 = new EnemyCharacter("enemy", new WarriorPriest(1, 10)) {
        };
        pg.damage(pg2);
        Assert.assertEquals(7, pg2.getCurrentHealth());
    }

    @Test
    public void testCharacterLevelUp() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorMage(2, 2)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(2, 2)) {
        };
        pg.setCurrentExperience(30);
        testCharacter.gainExperience(pg.getCurrentExperience());
        Assert.assertEquals(3, testCharacter.getLevel());
    }

    @Test
    public void testIsDead() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(2, 2)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(5, 2)) {
        };
        testCharacter.takeDamage(pg.getAttackValue());
        Assert.assertFalse(testCharacter.isAlive());
    }

    @Test
    public void testIsAlive() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorMage(2, 20)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(2, 2)) {
        };
        testCharacter.takeDamage(pg.getAttackValue());
        Assert.assertTrue(testCharacter.isAlive());
    }

    @Test
    public void testMagePriestAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(3, 3)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new MagePriest(1, 2)) {
        };
        pg.damage(testCharacter);
        Assert.assertEquals(1, testCharacter.getCurrentHealth());
    }

    @Test
    public void testWarriorMageAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorMage(3, 3)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(2, 2)) {
        };
        pg.damage(testCharacter);
        Assert.assertEquals(1, testCharacter.getCurrentHealth());
    }

    @Test
    public void testWarriorPriestRestoreHP() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(3, 10)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(3, 2)) {
        };
        PlayerCharacter pg2 = new PlayerCharacter("character", new WarriorPriest(1, 2)) {
        };
        pg.damage(testCharacter);
        pg2.doSpecialAbility(testCharacter);
        Assert.assertEquals(8, testCharacter.getCurrentHealth());
    }

    @Test
    public void testMagePriestRestoreHP() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(3, 10)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(3, 2)) {
        };
        PlayerCharacter pg2 = new PlayerCharacter("character", new MagePriest(1, 2)) {
        };
        pg.damage(testCharacter);
        pg2.doSpecialAbility(testCharacter);
        Assert.assertEquals(8, testCharacter.getCurrentHealth());
    }

    @Test
    public void testWarriorThiefSpecialAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Priest(3, 999)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorThief(2, 2)) {
        };
        pg.damage(testCharacter);
        Assert.assertEquals(997, testCharacter.getCurrentHealth());
        int counter = 500;
        int halfDamage = 0;
        int doubleDamage = 0;
        for (int i = 0; i < counter; i++) {
            testCharacter.setCurrentHealth(999);
            pg.doSpecialAbility(testCharacter);
            if (testCharacter.getCurrentHealth() == 998) {
                halfDamage++;
            } else if (testCharacter.getCurrentHealth() == 995) {
                doubleDamage++;
            }
        }
        Assert.assertTrue(halfDamage <= 300);
        System.out.println("Half Damage: " + halfDamage);
        Assert.assertTrue(doubleDamage <= 300);
        System.out.println("Double Damage: " + doubleDamage);
    }


}