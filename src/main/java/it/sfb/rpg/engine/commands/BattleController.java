package it.sfb.rpg.engine.commands;

import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.labyrinth.Labyrinth;

import java.util.Scanner;

public class BattleController {

    private Scanner scanner = new Scanner(System.in);

    public BattleController() {
    }

    public void battleManager(PlayerCharacter playerCharacter, EnemyCharacter enemyCharacter) {

        while (playerCharacter.isAlive() && enemyCharacter.isAlive()) {
            System.out.println("Choose an action{ATTACK or HEAL}: ");
            String input = scanner.nextLine().trim().toUpperCase();

            ECommands command = ECommands.valueOf(input);

            if (command.equals(ECommands.valueOf("ATTACK"))) {
                playerCharacter.damage(enemyCharacter);

                if (enemyCharacter.isAlive()) {
                    enemyCharacter.damage(playerCharacter);
                }
            } else if (command.equals(ECommands.valueOf("HEAL"))) {
                playerCharacter.heal(playerCharacter);

                if (enemyCharacter.isAlive()) {
                    enemyCharacter.damage(playerCharacter);
                } else {
                    System.out.println("Unknown Command");
                }
            }
        }
    }
}
