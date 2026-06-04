package it.sfb.rpg.entities;

public abstract class EnemyCharacter extends BattleCharacter implements IClass {

    public EnemyCharacter(String name, IClass clz) {
        super(name, clz);
    }
}
