package it.sfb.rpg.engine;

import it.sfb.rpg.engine.commands.CommandIngester;
import it.sfb.rpg.engine.commands.ECommands;
import it.sfb.rpg.engine.commands.MovementController;
import it.sfb.rpg.engine.generator.LabyrinthGenerator;
import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.WarriorThief;
import it.sfb.rpg.labyrinth.Labyrinth;

import java.util.Scanner;

public class Engine {

    private Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private LabyrinthGenerator generator;
    private Labyrinth labyrinth;
    private PlayerCharacter player;
    private EnemyCharacter enemy;

    public Engine(){
    };

    public static void start(){
        System.out.println("Game started");

        LabyrinthGenerator generator = new LabyrinthGenerator();
        Labyrinth labyrinth = generator.generateLabyrinth(10);
        PlayerCharacter pg = new PlayerCharacter("Franco", new WarriorThief(10,10)) {
        };
        MovementController controller = new MovementController(labyrinth, pg);
        CommandIngester ingester = new CommandIngester(controller);

        while(running){
            System.out.println("Enter command(MOVE,LOOK): ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().trim().toUpperCase();

            try {
                ingester.processInput(ECommands.valueOf(command));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command");
                continue;
            }

            ingester.processInput(ECommands.valueOf(command));
            System.out.println(labyrinth.getRoomPosition(controller.getPlayerPosition()));
        }
    };
}
