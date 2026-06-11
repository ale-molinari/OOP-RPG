package it.sfb.rpg.entities;

import it.sfb.rpg.engine.interactions.ITalk;

public abstract class PngCharacter extends GameCharacter implements ITalk {

    public PngCharacter(String name) {
        super(name);
    }
}
