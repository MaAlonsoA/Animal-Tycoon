package dev.maalonsoa.animaltycoon;

import java.awt.*;
import java.awt.image.BufferStrategy;

enum GameStatus {
    GAME_ACTIVE,
    GAME_PAUSE,
    GAME_MENU,
    GAME_END
}

public class Game implements Runnable {

    private Display display;
    private GameStatus gameStatus;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        display = new Display(title, width, height);
        gameStatus = GameStatus.GAME_ACTIVE;
    }

    public void run() {

        while (gameStatus != GameStatus.GAME_END){
            tick();
            render();

        }

        stop();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Draw here

        //End draw
        bs.show();
        g.dispose();
    }

    private void tick() {
    }


    public synchronized void start() {
        thread = new Thread();
        thread.start();
        run();
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
