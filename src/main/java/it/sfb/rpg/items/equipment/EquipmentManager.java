package it.sfb.rpg.items.equipment;

public class EquipmentManager {

    private EquipmentSlot<Weapon> weapon;
    private EquipmentSlot<Armor> armor;

    public EquipmentManager(){
        this.weapon = new EquipmentSlot<>();
        this.armor = new EquipmentSlot<>();
    }

    public Weapon equipWeapon(Weapon weapon) {
        Weapon oldWeapon = this.weapon.getItem();
        this.weapon.setItem(weapon);
        return oldWeapon;
    }

    public Armor equipArmor(Armor armor) {
        Armor oldArmor = this.armor.getItem();
        this.armor.setItem(armor);
        return oldArmor;
    }

    public int calculateDamageBonus(){
        int bonus = 0;
        if (this.weapon.isEmpty()){
            return bonus;
        }
        bonus += this.weapon.getItem().getAttackBuff();
        return bonus;
    }

    public int calculateHealthBonus(){
        int bonus = 0;
        if (this.armor.isEmpty()){
            return bonus;
        }
        bonus += this.armor.getItem().getHealthBuff();
        return bonus;
    }
}
