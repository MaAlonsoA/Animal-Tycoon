package dev.maalonsoa.animaltycoon;

import dev.maalonsoa.engine.State;
import dev.maalonsoa.engine.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    public GameState(){

    }
    @Override
    public void ticks() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerIdle, 0,0,null);
    }
}
