package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.IAttack;
import it.sfb.rpg.engine.interactions.IExperience;
import it.sfb.rpg.engine.interactions.IHealth;

public interface IBattle extends IHealth, IAttack, IExperience {

}
