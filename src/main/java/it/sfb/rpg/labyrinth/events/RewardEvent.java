package it.sfb.rpg.labyrinth.events;

import it.sfb.rpg.entities.PlayerCharacter;
import it.sfb.rpg.items.potions.IItem;
import it.sfb.rpg.labyrinth.IGameEvent;

import java.util.ArrayList;
import java.util.List;

public class RewardEvent implements IGameEvent {

    private List<IItem> items;

    public RewardEvent() {
        this.items = new ArrayList<>();
    }

    @Override
    public void triggerEvent(PlayerCharacter playerCharacter) {

        if (this.items.isEmpty()) {
            System.out.println("There are no items to loot");
            return;
        }

        for (int i = items.size() - 1; i >= 0; i--) {
            IItem item = this.items.get(i);
            if (!playerCharacter.getInventory().isFull()) {
                playerCharacter.getInventory().addItem(item);
                this.items.remove(i);
            } else {
                System.out.println("Inventory is full, you left some items behind");
                System.out.println(items.toString());
                break;
            }
        }
    }

    public void addItem(IItem item) {
        this.items.add(item);
    }

    public List<IItem> getItems() {
        return this.items;
    }
}
