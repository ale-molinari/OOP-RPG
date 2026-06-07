package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.engine.commands.*;

public class CommandIngester {

    private final GameContext gameContext;

    public CommandIngester(GameContext gameContext) {
        this.gameContext = gameContext;
    }

    public void processInput(ECommands input, String argument) {

        //TODO: Fix this switch for improve heap memory management
        ICommandHandler handler = switch (input) {
            case MOVE -> new MovementCommand();
            case LOOK -> new LookCommand();
            case ATTACK -> new AttackCommand();
            case STATS -> new StatsCommand();
            default -> null;
        };

        if (handler != null) {
            handler.handle(gameContext, argument);
        } else {
            System.out.println("Coming Soon");
        }
    }
}