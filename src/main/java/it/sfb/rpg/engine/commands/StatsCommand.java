package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.entities.PlayerCharacter;

public class StatsCommand implements ICommandHandler {

    @Override
    public void handle(GameContext gameContext, String command) {

        PlayerCharacter player = gameContext.getPlayer();

        System.out.println(player.getStats());
    }
}


