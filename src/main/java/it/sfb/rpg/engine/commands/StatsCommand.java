package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.entities.PlayerCharacter;

public class StatsCommand implements ICommandHandler {

    /**
     * Executes the stat logic, printing the player's status to the console.
     * @param gameContext the current state of the game
     * @param command the additional string argument passed with the command
     */
    @Override
    public void handle(GameContext gameContext, String command) {

        PlayerCharacter player = gameContext.getPlayer();

        System.out.println(player.getStats());
    }
}


