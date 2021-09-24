package dev.maalonsoa.animaltycoon.entities.creatures;

import dev.maalonsoa.engine.logic.Entity;

public abstract class Creature extends Entity {

    protected int health;

    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }

}
