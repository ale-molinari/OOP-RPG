package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.PlayerCharacter;

public interface IGameEvent {

    void triggerEvent(PlayerCharacter playerCharacter);

}
