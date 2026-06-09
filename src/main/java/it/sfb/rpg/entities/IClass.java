package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.IAttack;
import it.sfb.rpg.engine.interactions.IExperience;
import it.sfb.rpg.engine.interactions.IHealth;
import it.sfb.rpg.engine.interactions.IStats;

public interface IClass extends IHealth, IAttack, IExperience, IStats {
}
