package it.sfb.rpg.engine.printer;

import it.sfb.rpg.labyrinth.Labyrinth;
import it.sfb.rpg.labyrinth.RCoordinate;

public class MapPrinter {

    public static void printMap(Labyrinth labyrinth) {

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(RCoordinate coordinate : labyrinth.getMap().keySet()) {
            int actualX = coordinate.x();
            int actualY = coordinate.y();

            maxX = Math.max(actualX, maxX);
            minX = Math.min(actualX, minX);
            maxY = Math.max(actualY, maxY);
            minY = Math.min(actualY, minY);
        }

        for(int y = minY; y <= maxY; y++) {
            for(int x = minX; x <= maxX; x++) {
                RCoordinate actualCoordinate = new RCoordinate(x, y);

                if (labyrinth.getRoomPosition(actualCoordinate) != null) {
                    System.out.print(labyrinth.getRoomPosition(actualCoordinate).getSymbol());
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println("Map Created!");
    }
}
