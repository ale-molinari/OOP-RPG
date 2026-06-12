package it.sfb.rpg.engine;

import it.sfb.rpg.engine.commands.CommandIngester;
import it.sfb.rpg.engine.commands.ECommands;

import java.util.Scanner;

public class Engine {

    private static boolean running = true;
    private static final Scanner scanner = new Scanner(System.in);

    public Engine(){
    };

    public static void start(CommandIngester ingester, GameContext gameContext){
        System.out.println("Game started");
        while(running){
            System.out.println("Enter command(MOVE,LOOK,ATTACK,STATS,QUIT): ");
            String commandStr = scanner.nextLine().trim().toUpperCase();

            if (commandStr.equals("QUIT")) {
                System.out.println("Game ended");
                running = false;
                break;
            }

            try {
                ECommands command = ECommands.valueOf(commandStr);
                String argument = "";
                if (command == ECommands.MOVE || command == ECommands.LOOK) {
                    System.out.println("Enter direction: " + gameContext.getCurrentRoom().getAvailableDirections());
                    argument = scanner.nextLine().trim().toUpperCase();
                }
                ingester.processInput(command, argument);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command");
            }
        }
    }
}
