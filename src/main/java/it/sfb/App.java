package it.sfb;

import it.sfb.rpg.engine.commands.CommandIngester;
import it.sfb.rpg.engine.commands.ECommands;
import it.sfb.rpg.engine.commands.MovementController;
import it.sfb.rpg.engine.generator.LabyrinthGenerator;
import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.WarriorThief;
import it.sfb.rpg.labyrinth.SafeRoom;
import it.sfb.rpg.labyrinth.TreasureRoom;
import it.sfb.rpg.labyrinth.events.HealEvent;
import it.sfb.rpg.labyrinth.events.RewardEvent;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        TreasureRoom treasureRoom = new TreasureRoom("Treasure", new RewardEvent());
    }
}
