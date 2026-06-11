package it.sfb.rpg.labyrinth;

public class TreasureRoom extends Room {

    public TreasureRoom(String name, IGameEvent evnt) {
        super(name, evnt);
    }

    @Override
    public String getSymbol() {
        return "[T]";
    }
}
