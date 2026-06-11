package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;
import it.sfb.rpg.engine.commands.*;

import java.util.EnumMap;
import java.util.Map;

public class CommandIngester {

    private  final Map<ECommands, ICommandHandler> handlers;
    private final GameContext gameContext;

    public CommandIngester(GameContext gameContext) {
        this.gameContext = gameContext;
        this.handlers = new EnumMap<>(ECommands.class);

        handlers.put(ECommands.MOVE, new MovementCommand());
        handlers.put(ECommands.LOOK, new LookCommand());
        handlers.put(ECommands.ATTACK, new AttackCommand());
        handlers.put(ECommands.STATS, new StatsCommand());
    }

    public void processInput(ECommands input, String argument) {

        ICommandHandler handler = handlers.get(input);

        if (handler != null) {
            handler.handle(gameContext, argument);
        } else {
            System.out.println("Coming Soon");
        }
    }
}