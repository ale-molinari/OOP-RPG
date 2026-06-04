package it.sfb.rpg.labyrinth.events;

import it.sfb.rpg.entities.PlayerCharacter;

public abstract class Event implements IGameEvent {

    public abstract void triggerEvent(PlayerCharacter playerCharacter);
}
