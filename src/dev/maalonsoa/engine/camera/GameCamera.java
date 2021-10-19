package dev.maalonsoa.engine.camera;

import dev.maalonsoa.animaltycoon.Game;
import dev.maalonsoa.animaltycoon.Handler;
import dev.maalonsoa.engine.logic.Entity;

public class GameCamera {

    private float xOffset;
    private float yOffset;
    private Handler handler;

    public GameCamera(float xOffset, float yOffset, Handler handler) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() - handler.getScrWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - handler.getScrHeight() / 2 + entity.getHeight() / 2;
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
