package dev.maalonsoa.engine;

import java.awt.*;

public abstract class State {

    public abstract void ticks();

    public abstract void render (Graphics g);

}
