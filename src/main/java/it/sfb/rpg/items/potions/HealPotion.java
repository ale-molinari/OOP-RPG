package it.sfb.rpg.items.potions;

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
    public void use(PlayerCharacter player) {
        int healedHp = Math.clamp(player.getCurrentHealth() + healAmount, 0, player.getHealth());
        player.setCurrentHealth(healedHp);
    };
}
