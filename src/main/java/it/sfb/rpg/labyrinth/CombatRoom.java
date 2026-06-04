package it.sfb.rpg.labyrinth;

import it.sfb.rpg.entities.EnemyCharacter;
import it.sfb.rpg.labyrinth.events.IGameEvent;

import java.util.ArrayList;

public class CombatRoom extends Room {
    private ArrayList<EnemyCharacter> enemies;

    public CombatRoom(String name, IGameEvent event) {
        super(name);
        this.event = event;
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

    @Override
    public String getSymbol() {
        return "[C]";
    }
}
