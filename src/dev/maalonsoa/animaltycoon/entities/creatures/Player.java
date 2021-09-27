package dev.maalonsoa.animaltycoon.entities.creatures;

import dev.maalonsoa.animaltycoon.Game;
import dev.maalonsoa.engine.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private final Game game;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKeyManager().up) {
            y -= 3;
        }else if (game.getKeyManager().dow){
            y += 3;
        } else if(game.getKeyManager().left){
            x -=3;
        }else if (game.getKeyManager().right){
            x += 3;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerIdle, (int) x, (int) y, null);
    }
}
