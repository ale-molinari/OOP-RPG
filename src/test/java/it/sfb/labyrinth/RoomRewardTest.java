package it.sfb.labyrinth;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.entities.classes.Priest;
import it.sfb.rpg.items.equipment.PocketKnife;
import it.sfb.rpg.items.equipment.Sword;
import it.sfb.rpg.labyrinth.TreasureRoom;
import it.sfb.rpg.labyrinth.events.RewardEvent;
import org.junit.Assert;
import org.junit.Test;

public class RoomRewardTest {

    @Test
    public void testRewardLoot() throws Exception {
        PlayerCharacter pg = new PlayerCharacter("testCharacter", new Priest(1,1)) {
        };
        RewardEvent rewardEvent = new RewardEvent();
        TreasureRoom treasureRoom = new TreasureRoom("testRoom", rewardEvent);
        PocketKnife knife = new PocketKnife("pocket knife");
        Sword sword = new Sword("sword");
        rewardEvent.addItem(sword);
        rewardEvent.addItem(knife);
        Assert.assertEquals(2, rewardEvent.getItems().size());
        treasureRoom.triggerEvent(pg);
        Assert.assertEquals(0, rewardEvent.getItems().size());
        Assert.assertEquals(2, pg.getInventory().getItems().size());
    }
}
