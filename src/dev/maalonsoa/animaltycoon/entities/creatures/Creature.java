package dev.maalonsoa.animaltycoon.entities.creatures;

import dev.maalonsoa.animaltycoon.Game;
import dev.maalonsoa.animaltycoon.Handler;
import dev.maalonsoa.engine.logic.Entity;
import dev.maalonsoa.engine.tiles.Tile;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;
    protected int health;
    protected float speed;

    protected float xMove;
    protected float yMove;

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    void collisionBox(Graphics g, boolean active) {
        if (active) {
            g.setColor(Color.red);
            g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                    bounds.width, bounds.height);
        }

    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        if (xMove > 0) {
            int tempMove = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if (!collisionWithTile(tempMove, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
                    && !collisionWithTile(tempMove, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }
        } else if (xMove < 0) {
            int toMove = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if (!collisionWithTile(toMove, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
                    && !collisionWithTile(toMove, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {
            int tempMove = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, tempMove)
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, tempMove)) {
                y += yMove;
            }
        } else if (yMove > 0) {
            int tempMove = (int) (y + yMove + +bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, tempMove)
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, tempMove)) {
                y += yMove;
            }

        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }
}
