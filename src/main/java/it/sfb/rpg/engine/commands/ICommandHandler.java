package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;

public interface ICommandHandler {

    void handle(GameContext gameContext, String command);
}
