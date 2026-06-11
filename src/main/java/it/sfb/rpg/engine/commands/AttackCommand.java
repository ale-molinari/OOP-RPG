package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.items.IItem;
import it.sfb.rpg.labyrinth.CombatRoom;
import it.sfb.rpg.labyrinth.Room;

import java.util.List;


public class AttackCommand implements ICommandHandler {

    @Override
    public void handle(GameContext gameContext, String command) {

        Room currentRoom = gameContext.getCurrentRoom();
        PlayerCharacter player = gameContext.getPlayer();

        if (!(currentRoom instanceof CombatRoom combatRoom) || !combatRoom.hasAliveEnemies()) {
            System.out.println("You swing your weapon at the air");
            return;
        }

        EnemyCharacter currentEnemy = combatRoom.getFirstEnemy();

        System.out.println("You Attack the Enemy");
        player.damage(currentEnemy);

        enemyCounterAttack(player, currentEnemy);
    }

    public void enemyCounterAttack(PlayerCharacter playerCharacter, EnemyCharacter enemyCharacter) {
        if (enemyCharacter.isAlive()) {
            System.out.println("The enemy attacks you");
            enemyCharacter.damage(playerCharacter);

            if (!playerCharacter.isAlive()) {
                System.out.println("You have been defeated");
            }
        } else {
            System.out.println("You win the battle");
            List<IItem> items = enemyCharacter.getItems();
            playerCharacter.takeLoot(items);
        }
    }
}
