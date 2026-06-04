package it.sfb.rpg.labyrinth.events;

import it.sfb.rpg.entities.PlayerCharacter;

import java.util.Random;

public class CombatEvent extends Event {

    private boolean isClear = false;

    @Override
    public void triggerEvent(PlayerCharacter playerCharacter) {

        if (isClear) {
            System.out.println("This room is silent");
            return;
        }

        Random random = new Random();

        int ambush = 2;
        if (random.nextInt(4) == 3) {
            playerCharacter.setCurrentHealth(Math.clamp(playerCharacter.getCurrentHealth() - ambush, 0, playerCharacter.getHealth()));
            System.out.println("you took damage in the dark");
        }
        isClear = true;
    }
}

