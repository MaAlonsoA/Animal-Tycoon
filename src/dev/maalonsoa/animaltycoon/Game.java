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

    private final Display display;
    private final GameStatus gameStatus;
    private final int scrWidth;
    private final int scrHeight;
    private Thread thread;

    public Game(String title, int scrWidth, int scrHeight) {
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        display = new Display(title, scrWidth, scrHeight);
        gameStatus = GameStatus.GAME_ACTIVE;
    }

    public void run() {

        while (gameStatus != GameStatus.GAME_END) {
            tick();
            render();

        }

        stop();
    }

    private void render() {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0,0, scrWidth, scrHeight);
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
