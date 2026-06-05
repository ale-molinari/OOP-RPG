package it.sfb.rpg.engine;

import it.sfb.rpg.engine.commands.CommandIngester;
import it.sfb.rpg.engine.generator.LabyrinthGenerator;
import it.sfb.rpg.engine.printer.MapPrinter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.GameClass;
import it.sfb.rpg.entities.classes.MagePriest;
import it.sfb.rpg.entities.classes.WarriorPriest;
import it.sfb.rpg.entities.classes.WarriorThief;
import it.sfb.rpg.labyrinth.Labyrinth;

import java.util.Scanner;

public class GameBuilder {

    public static void setupAndRun() {
        Scanner scanner = new Scanner(System.in);

        PlayerCharacter player = createPlayer(scanner);
        Labyrinth labyrinth = createLabyrinth(scanner);

        GameContext context = new GameContext(labyrinth, player);
        CommandIngester ingester = assembleSystems(context);

        System.out.println("Welcome to the game, " + player.getName() + "!");
        MapPrinter.printMap(labyrinth);
        Engine.start(ingester, context);
    }

    private static PlayerCharacter createPlayer(Scanner scanner) {
        System.out.print("Hero name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Select Class:\n1) Warrior-Thief\n2) Mage-Priest\n3) Warrior-Priest");
        int classChoice = scanner.nextInt();

        GameClass selectedClass = switch (classChoice) {
            case 2 -> new MagePriest(12, 40);
            case 3 -> new WarriorPriest(15, 60);
            default -> new WarriorThief(10, 50);
        };

        return new PlayerCharacter(name, selectedClass) {};
    }

    private static Labyrinth createLabyrinth(Scanner scanner) {
        System.out.print("Number of rooms: ");
        int roomAmount = scanner.nextInt();

        LabyrinthGenerator generator = new LabyrinthGenerator();
        return generator.generateLabyrinth(roomAmount);
    }

    private static CommandIngester assembleSystems(GameContext context) {
        return new CommandIngester(context);
    }
}
