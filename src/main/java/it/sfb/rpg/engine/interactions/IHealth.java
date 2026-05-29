package it.sfb.rpg.engine.interactions;

public interface IHealth {
    default boolean isAlive() {
        return getCurrentHealth() > 0;
    }
    int getHealth();
    void setHealth(int hp);
    int getCurrentHealth();
    void setCurrentHealth(int currentHp);

    /**
     * Take damage and return if a character is alive after dmg
     * @param damage dmg to take
     * @return if it's still alive
     */
    default boolean takeDamage(int damage) {
        int finalHp = Math.clamp(getCurrentHealth() - damage, 0, getHealth());
        setCurrentHealth(finalHp);
        return isAlive();
    }

}
