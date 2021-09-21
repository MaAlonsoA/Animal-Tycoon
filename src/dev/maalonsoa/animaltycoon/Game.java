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
    private final int scrWidth;
    private final int scrHeight;
    private final String title;
    private Thread thread;

    public Game(String title, int scrWidth, int scrHeight) {
        this.title = title;
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        gameStatus = GameStatus.GAME_ACTIVE;
    }


    private void render() {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, scrWidth, scrHeight);
        //Draw here

        //End draw
        bs.show();
        g.dispose();
    }

    private void tick() {
    }

    private void init() {
        display = new Display(title, scrWidth, scrHeight);
    }

    public void run() {
        init();
        while (gameStatus != GameStatus.GAME_END) {
            tick();
            render();
        }

        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        run();
    }

    public synchronized void stop() {
        gameStatus = GameStatus.GAME_END;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
