package it.sfb.rpg.engine;

import it.sfb.rpg.engine.commands.CommandIngester;
import it.sfb.rpg.engine.generator.LabyrinthGenerator;
import it.sfb.rpg.engine.printer.MapPrinter;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.*;
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

        System.out.println("Select Class:\n1) Hunter\n2) Mystic\n3) Paladin\n4) Magus\n5) Thief\n6) Warrior\n7) Mage\n8) Priest");
        int classChoice = scanner.nextInt();

        GameClass selectedClass = switch (classChoice) {
            case 2 -> new Mystic(12, 40);
            case 3 -> new Paladin(13, 60);
            case 4 -> new Magus(11, 50);
            case 5 -> new Thief(9, 35);
            case 6 -> new Warrior(15, 65);
            case 7 -> new Mage(10, 40);
            case 8 -> new Priest(8, 40);
            default -> new Hunter(10, 50);
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
