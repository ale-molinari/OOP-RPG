package it.sfb.rpg.labyrinth.events;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.labyrinth.IGameEvent;

import java.util.Random;

public class RewardEvent implements IGameEvent {

    private boolean isLooted = false;

    @Override
    public void triggerEvent(PlayerCharacter playerCharacter) {

        if (isLooted) {
            System.out.println("You already looted this room");
            return;
        }

        Random random = new Random();

        int reward = random.nextInt(100)+1;

        if (reward <= 50) {
            playerCharacter.gainExperience(10);
            System.out.println("You get some experience");
        } else if (reward < 85) {
            int attackUpgrade = Math.max(1, (int) (playerCharacter.getAttackValue()*0.15));
            playerCharacter.setAttackValue(playerCharacter.getAttackValue()+attackUpgrade);
            System.out.println("You get an attack bonus");
        } else {
            int healthUpgrade = Math.max(1,(int) (playerCharacter.getHealth()*0.25));
            playerCharacter.setHealth(playerCharacter.getHealth()+healthUpgrade);
            System.out.println("You get a health bonus");
        }

        isLooted = true;
    }
}
