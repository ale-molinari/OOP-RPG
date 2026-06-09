package it.sfb.rpg.items.potions;

import it.sfb.rpg.entities.BattleCharacter;
import it.sfb.rpg.entities.PlayerCharacter;

public class ExpPotion extends Potion{

    private int expAmount;

    public ExpPotion(int expAmount) {
        super("Exp Potion");
        this.expAmount = expAmount;
    }

    public int getExpAmount() {
        return expAmount;
    }

    public void setExpAmount(int expAmount){
        this.expAmount = expAmount;
    }

    @Override
    public void use(BattleCharacter character) {
        character.gainExperience(expAmount);
    }
}
