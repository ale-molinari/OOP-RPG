package it.sfb.entities;

import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

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
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(3, 3)) { };
        PlayerCharacter pg = new PlayerCharacter("character", new MagePriest(1, 2)) { };
        pg.damage(testCharacter);
        Assert.assertEquals(1, testCharacter.getCurrentHealth());
    }

    @Test
    public void testWarriorMageAttack() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorMage(3, 3)) { };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(2, 2)) { };
        pg.damage(testCharacter);
        Assert.assertEquals(1, testCharacter.getCurrentHealth());
    }

    @Test
    public void testPWarriorPriestRestoreHP() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(3, 10)) { };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(3, 2)) { };
        PlayerCharacter pg2 = new PlayerCharacter("character", new WarriorPriest(1, 2)) { };
        testCharacter.damage(pg);
        pg2.damage(pg);
        Assert.assertEquals(10, testCharacter.getCurrentHealth());
    }

    @Test
    public void testMagePriestRestoreHP() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new MagePriest(3, 10)) { };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorMage(3, 2)) { };
        PlayerCharacter pg2 = new PlayerCharacter("character", new MagePriest(1, 2)) { };
        testCharacter.damage(pg);
        pg2.damage(pg);
        Assert.assertEquals(10, testCharacter.getCurrentHealth());
    }

    @Test
    public void TestWarriorThiefCriticalDamage() throws Exception {
        PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorThief(3, 10)) { };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorThief(3, 10)) {
            @Override
            public void damage(IHealth health){
                int dmg = getAttackValue()*2;
                health.takeDamage(dmg);
            }
        };
        pg.damage(testCharacter);
        Assert.assertEquals(5, testCharacter.getCurrentHealth());
    }

    @Test
    public void TestWarriorThiefNormalAttack() throws Exception{
        PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorThief(3, 10)) { };
        PlayerCharacter pg = new PlayerCharacter("character", new WarriorThief(3, 10)) {
            @Override
            public void damage(IHealth health) {
                int dmg = getAttackValue();
                health.takeDamage(dmg);
            }
        };
        pg.damage(testCharacter);
        Assert.assertEquals(8, testCharacter.getCurrentHealth());
    }

    @Test
    public void TestWarriorThiefRandomCriticalAttack() throws Exception{
        int critical = 0;
        int normal = 0;
        int attackAmount = 1000;

        for (int i = 0; i < attackAmount; i++){
            PlayerCharacter testCharacter = new PlayerCharacter("character", new WarriorThief(3, 10)) { };
            PlayerCharacter pg = new PlayerCharacter("character", new WarriorThief(5, 10)) { };
            pg.damage(testCharacter);

            if (testCharacter.getCurrentHealth() == 1) {
                critical++;
            } else if (testCharacter.getCurrentHealth() == 6) {
                normal++;
            } else {
                Assert.fail("character settings are not right");
            }
        }
        System.out.println("Critical: " + critical);
        Assert.assertTrue(critical < 330);
    }
}