package it.sfb.rpg.engine.interactions;

import it.sfb.rpg.entities.PlayerCharacter;

public interface IEnterRoom {
        void setPlayerInTheRoom(PlayerCharacter player);
        boolean getPlayerInTheRoom();
}
