package it.sfb;

import it.sfb.rpg.labyrinth.SafeRoom;
import it.sfb.rpg.labyrinth.events.HealEvent;

public class App {

    public static void main(String[] args) throws Exception {
        SafeRoom safeRoom = new SafeRoom("Safe Room", new HealEvent());
    }
}
