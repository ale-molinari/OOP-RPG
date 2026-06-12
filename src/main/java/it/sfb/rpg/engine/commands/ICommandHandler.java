package it.sfb.rpg.engine.commands;

import it.sfb.rpg.engine.GameContext;

public interface ICommandHandler {

    /**
     * Executes the specific command logic.
     * @param gameContext the current state of the game
     * @param command the argument string associated with the command
     */
    void handle(GameContext gameContext, String command);
}
