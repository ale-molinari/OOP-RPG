package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.PngCharacter;
import it.sfb.rpg.labyrinth.events.IGameEvent;

public class SafeRoom extends Room {
    private PngCharacter[] pngCharacters;

    public SafeRoom(String roomName, IGameEvent event) {
        super(roomName);
        this.event = event;
    }

    @Override
    public String getSymbol() {
        return "[S]";
    }
}
