package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.EnemyCharacter;

import java.util.ArrayList;
import java.util.List;

public class CombatRoom extends Room  {

    private final List<EnemyCharacter> enemies;

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
        return enemies.stream()
                .anyMatch(enemy -> enemy.getCurrentHealth() > 0);
        }

    public EnemyCharacter getFirstEnemy() {
        return enemies.isEmpty() ? null : enemies.getFirst();
    }

    public List<EnemyCharacter> getEnemies() {
        return this.enemies;
    }

    @Override
    public String getSymbol() {
        return "[C]";
    }
}
