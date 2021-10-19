package dev.maalonsoa.animaltycoon.entities.creatures;

import dev.maalonsoa.animaltycoon.Handler;
import dev.maalonsoa.engine.gfx.Animation;
import dev.maalonsoa.engine.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation animDown;
    private Animation animUp;
    private Animation animRight;
    private Animation animLeft;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        bounds.y = 32;
        bounds.height = 32;
        bounds.width = 32;

        animDown = new Animation(500, Assets.playerDown);
        animUp = new Animation(500, Assets.playerUp);
        animRight = new Animation(500, Assets.playerRight);
        animLeft = new Animation(500, Assets.playerLeft);
    }

    @Override
    public void tick() {
        updateAnim();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void updateAnim() {
        animDown.tick();
        animLeft.tick();
        animRight.tick();
        animUp.tick();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        //Show collision Box
        collisionBox(g, false);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else {
            return animDown.getCurrentFrame();
        }
    }
}
