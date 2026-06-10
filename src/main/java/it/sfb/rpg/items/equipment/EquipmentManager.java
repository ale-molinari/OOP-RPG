package it.sfb.rpg.items.equipment;

/**
 * Manages the currently equipped items for a character.
 */

public class EquipmentManager {

    private Weapon weapon;
    private Armor armor;

    public EquipmentManager(){
        this.weapon = null;
        this.armor = null;
    }

    /**
     * Equips a weapon and returns the previously equipped one.
     * @param weapon the new weapon to equip
     * @return the old weapon, or null if the slot was empty
     */
    public Weapon equipWeapon(Weapon weapon) {
        Weapon oldWeapon = this.weapon;
        this.weapon = weapon;
        return oldWeapon;
    }

    /**
     * Equips an armor and returns the previously equipped one.
     * @param armor the new armor to equip
     * @return the old armor, or null if the slot was empty
     */
    public Armor equipArmor(Armor armor) {
        Armor oldArmor = this.armor;
        this.armor = armor;
        return oldArmor;
    }

    /**
     * Calculates the total damage bonus provided by the equipped weapon.
     * @return the attack buff value, or 0 if no weapon is equipped
     */
    public int calculateDamageBonus(){
        int bonus = 0;
        if (this.weapon == null){
            return bonus;
        }
        bonus += this.weapon.getAttackBuff();
        return bonus;
    }

    /**
     * Calculates the total health bonus provided by the equipped armor.
     * @return the health buff value, or 0 if no armor is equipped
     */
    public int calculateHealthBonus(){
        int bonus = 0;
        if (this.armor == null){
            return bonus;
        }
        bonus += this.armor.getHealthBuff();
        return bonus;
    }
}
