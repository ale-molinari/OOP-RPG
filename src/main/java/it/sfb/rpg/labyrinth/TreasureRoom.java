package it.sfb.rpg.labyrinth;

import it.sfb.rpg.labyrinth.events.IGameEvent;

public class TreasureRoom extends Room {
    Object[] items;

    public TreasureRoom(String name, IGameEvent event) {
        super(name);
        this.event = event;
    }

    @Override
    public String getSymbol() {
        return "[T]";
    }
}
