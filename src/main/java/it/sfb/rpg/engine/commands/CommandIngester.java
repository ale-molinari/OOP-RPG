package it.sfb.rpg.engine.commands;

public class CommandIngester {

    private MovementController controller;

    public CommandIngester(MovementController controller) {
        this.controller = controller;
    }

    public void processInput(ECommands input) {

        switch (input) {
            case MOVE -> controller.updatePlayerPosition();
            case LOOK -> controller.lookAround();
        }
    }
}