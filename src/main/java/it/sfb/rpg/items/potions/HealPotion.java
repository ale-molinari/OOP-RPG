package it.sfb.rpg.items.potions;

import it.sfb.rpg.entities.BattleCharacter;
import it.sfb.rpg.entities.PlayerCharacter;

public class HealPotion extends Potion{
    private int healAmount;

    public HealPotion(int healAmount) {
        super("Heal Potion");
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void use(BattleCharacter character) {
        int healedHp = Math.clamp(character.getCurrentHealth() + healAmount, 0, character.getHealth());
        character.setCurrentHealth(healedHp);
    };
}
