package dev.maalonsoa.animaltycoon.entities.creatures;

import dev.maalonsoa.engine.gfx.Assets;

import java.awt.*;

public class Player extends Creature{


    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerIdle, (int)x, (int)y, null);
    }
}
