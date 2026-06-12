package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.PngCharacter;

public class SafeRoom extends Room {

    private PngCharacter pngCharacters;

    public SafeRoom(String roomName, IGameEvent evnt) {
        super(roomName, evnt);
    }

    @Override
    public String getSymbol() {
        return "[S]";
    }
}
