package it.sfb.rpg.engine.interactions;

public interface IAttack {
    int getAttackValue();
    void setAttackValue(int attack);

    /**
     * Generic function to take damage
     * @param health the health interface to receive damage
     */
    default void damage(IHealth health) {
        health.takeDamage(getAttackValue());
    }

}
