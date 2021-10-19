package dev.maalonsoa.engine.logic;

import dev.maalonsoa.animaltycoon.Game;
import dev.maalonsoa.animaltycoon.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    //CLASS
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
