package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.IHealth;

public abstract class EnemyCharacter extends BattleCharacter implements IBattle {

    public EnemyCharacter(String name, IBattle clz) {
        super(name, clz);
    }
}
