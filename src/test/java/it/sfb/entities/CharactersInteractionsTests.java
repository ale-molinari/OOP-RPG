package it.sfb.entities;

import it.sfb.rpg.controllers.Player;
import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.GameCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Deprived;
import it.sfb.rpg.entities.classes.Mage;
import it.sfb.rpg.entities.classes.Priest;
import it.sfb.rpg.entities.classes.Warrior;
import org.junit.Assert;
import org.junit.Test;

public class CharactersInteractionsTests {

    @Test
    public void testWarriorDefense() throws Exception {
        GameCharacter testCharacter = new GameCharacter(new Deprived("character", 2, 1)) { };
        EnemyCharacter pg = new EnemyCharacter(new Warrior("warrior", 1, 10));
        testCharacter.getRole().damage(pg.getRole());
        Assert.assertEquals(9, pg.getCurrentHealth());
    }

    @Test
    public void testCharacterLevelUp() throws Exception {
        GameCharacter testCharacter = new GameCharacter(new Deprived("character", 2, 1)) { };
        Warrior pg = new Warrior("warrior", 1, 10);
        pg.setCurrentExperience(30);
        testCharacter.getRole().gainExperience(pg.getCurrentExperience());
        Assert.assertEquals(3, testCharacter.getLevel());
    }

    @Test
    public void testIsDead() throws  Exception {
        GameCharacter testCharacter = new GameCharacter(new Deprived("character", 2, 1)) { };
        Warrior pg = new Warrior("warrior", 10, 10);
        testCharacter.getRole().takeDamage(pg.getAttackValue());
        Assert.assertFalse(testCharacter.getRole().isAlive());
    }

    @Test
    public void testIsAlive() throws  Exception {
        GameCharacter testCharacter = new GameCharacter(new Deprived("character", 2, 10)) { };
        Warrior pg = new Warrior("warrior", 9, 10);
        testCharacter.getRole().takeDamage(pg.getAttackValue());
        Assert.assertTrue(testCharacter.getRole().isAlive());
    }

    @Test
    public void testMageAttack() throws Exception {
        GameCharacter testCharacter = new GameCharacter(new Deprived("character", 2, 4)) { };
        Mage pg = new Mage("Mage", 1, 10);
        pg.damage(testCharacter.getRole());
        Assert.assertEquals(2, testCharacter.getCurrentHealth());
    }

    @Test
    public void testPriestRestoreHP() throws Exception {
        GameCharacter testCharacter = new GameCharacter(new Deprived ("character", 3, 10)) { };
        Warrior pg = new Warrior("warrior", 4, 10);
        pg.damage(testCharacter.getRole());
        Priest priest  = new Priest("Priest", 1, 10);
        priest.damage(testCharacter.getRole());
        Assert.assertEquals(8, testCharacter.getCurrentHealth());
    }

}
