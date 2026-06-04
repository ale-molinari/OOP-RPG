package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.EnemyCharacter;

import java.io.Serializable;
import java.util.ArrayList;

public class CombatRoom extends Room  {

    private ArrayList<EnemyCharacter> enemies;

    public CombatRoom(String name, IGameEvent evnt) {
        super(name, evnt);
        this.enemies = new ArrayList<>();
    }

    public void addEnemies(EnemyCharacter enemy) {
        if (enemy != null) {
            this.enemies.add(enemy);
        }
    }

    public boolean hasAliveEnemies() {
        for (EnemyCharacter enemy : this.enemies) {
            if (enemy.getCurrentHealth() > 0) {
                return true;
            }
        } return false;
    }

    public EnemyCharacter getFirstEnemy() {
        if (this.enemies.isEmpty()) return null;
        return this.enemies.getFirst();
    }

    @Override
    public String getSymbol() {
        return "[C]";
    }
}
