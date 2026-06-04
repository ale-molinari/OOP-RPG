package it.sfb.rpg.labyrinth.events;

import it.sfb.rpg.entities.PlayerCharacter;

public class HealEvent extends Event {
    private int remainingTreatments = 3;

    @Override
    public void triggerEvent(PlayerCharacter playerCharacter) {
        if (playerCharacter.getCurrentHealth() == playerCharacter.getHealth()) {
            System.out.println("You think you could rest here, but now you don't need to");
            return;
        }
        if (remainingTreatments > 0) {
            int healing = (int) (playerCharacter.getHealth() * 0.10);
            int hp = Math.clamp(playerCharacter.getCurrentHealth() + healing, 0, playerCharacter.getHealth());
            playerCharacter.setCurrentHealth(hp);
            remainingTreatments--;
            System.out.println("You get some rest");
            System.out.println("You have been healed for " + healing + " HP");
        } else {
            System.out.println("You don't want to rest anymore");
        }
    }
}
