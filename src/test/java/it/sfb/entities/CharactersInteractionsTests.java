package it.sfb.entities;

import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.*;
import org.junit.Assert;
import org.junit.Test;

public class CharactersInteractionsTests {

    @Test
    public void testMagusDefense() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(5, 10)) {
        };
        EnemyCharacter pg2 = new EnemyCharacter("enemy", new Magus(1, 10)) {
        };
        pg.damage(pg2);
        Assert.assertEquals(5, pg2.getCurrentHealth());
    }

    @Test
    public void testPaladinDefense() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("character", new Paladin(4, 10)) {
        };
        EnemyCharacter pg2 = new EnemyCharacter("enemy", new Paladin(1, 10)) {
        };
        pg.damage(pg2);
        Assert.assertEquals(7, pg2.getCurrentHealth());
    }

    @Test
    public void testCharacterLevelUp() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Magus(2, 2)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(2, 2)) {
        };
        pg.setCurrentExperience(30);
        testCharacter.gainExperience(pg.getCurrentExperience());
        Assert.assertEquals(3, testCharacter.getLevel());
    }

    @Test
    public void testIsDead() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Mystic(2, 2)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(5, 2)) {
        };
        testCharacter.takeDamage(pg.getAttackValue());
        Assert.assertFalse(testCharacter.isAlive());
    }

    @Test
    public void testIsAlive() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Magus(2, 20)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(2, 2)) {
        };
        testCharacter.takeDamage(pg.getAttackValue());
        Assert.assertTrue(testCharacter.isAlive());
    }

    @Test
    public void testMysticAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Mystic(3, 3)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Mystic(1, 2)) {
        };
        pg.damage(testCharacter);
        Assert.assertEquals(1, testCharacter.getCurrentHealth());
    }

    @Test
    public void testMagusAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Magus(3, 3)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(2, 2)) {
        };
        pg.damage(testCharacter);
        Assert.assertEquals(1, testCharacter.getCurrentHealth());
    }

    @Test
    public void testPaladinRestoreHP() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Mystic(3, 10)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(3, 2)) {
        };
        PlayerCharacter pg2 = new PlayerCharacter("character", new Paladin(1, 2)) {
        };
        pg.damage(testCharacter);
        pg2.doSpecialAbility(testCharacter);
        Assert.assertEquals(8, testCharacter.getCurrentHealth());
    }

    @Test
    public void testMysticRestoreHP() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Mystic(3, 10)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Magus(3, 2)) {
        };
        PlayerCharacter pg2 = new PlayerCharacter("character", new Mystic(1, 2)) {
        };
        pg.damage(testCharacter);
        pg2.doSpecialAbility(testCharacter);
        Assert.assertEquals(8, testCharacter.getCurrentHealth());
    }

    @Test
    public void testHunterSpecialAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new Priest(3, 999)) {
        };
        PlayerCharacter pg = new PlayerCharacter("character", new Hunter(2, 2)) {
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