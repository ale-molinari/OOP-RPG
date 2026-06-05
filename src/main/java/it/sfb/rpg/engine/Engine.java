package it.sfb.rpg.engine;

import it.sfb.rpg.engine.commands.CommandIngester;
import it.sfb.rpg.engine.commands.ECommands;

import java.util.Scanner;

public class Engine {

    private static boolean running = true;

    public Engine(){
    };

    public static void start(CommandIngester ingester, GameContext gameContext){
        System.out.println("Game started");
        while(running){
            System.out.println("Enter command(MOVE,LOOK,ATTACK,STATS,QUIT): ");
            Scanner scanner = new Scanner(System.in);
            String commandStr = scanner.nextLine().trim().toUpperCase();

            if (commandStr.equals("QUIT")) {
                System.out.println("Game ended");
                running = false;
                break;
            }

            try {
                ECommands command = ECommands.valueOf(commandStr);
                String argument = "";
                if (command.equals(ECommands.valueOf("MOVE")) || command.equals(ECommands.valueOf("LOOK"))) {
                    System.out.println("Enter direction: " + gameContext.getCurrentRoom().getAvailableDirections());
                    argument = scanner.nextLine().trim().toUpperCase();
                }
                ingester.processInput(command, argument);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command");
            }
        }
    };
}
