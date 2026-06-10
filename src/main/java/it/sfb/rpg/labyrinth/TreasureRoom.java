package it.sfb.rpg.labyrinth;

import it.sfb.rpg.items.potions.IItem;
import it.sfb.rpg.labyrinth.events.RewardEvent;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom extends Room {

    public TreasureRoom(String name, IGameEvent evnt) {
        super(name, evnt);
    }

    @Override
    public String getSymbol() {
        return "[T]";
    }
}
