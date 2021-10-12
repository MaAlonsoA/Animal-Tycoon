package dev.maalonsoa.engine.camera;

import dev.maalonsoa.animaltycoon.Game;
import dev.maalonsoa.engine.logic.Entity;

public class GameCamera {

    private float xOffset;
    private float yOffset;
    private Game game;

    public GameCamera(float xOffset, float yOffset, Game game) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.game = game;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() - game.getScrWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - game.getScrHeight() / 2 + entity.getHeight() / 2;
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
