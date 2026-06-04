package it.sfb.rpg.labyrinth.events;

import it.sfb.rpg.entities.PlayerCharacter;

public interface IGameEvent {

    void triggerEvent(PlayerCharacter playerCharacter);
}
