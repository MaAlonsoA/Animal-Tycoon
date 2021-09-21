package dev.maalonsoa.animaltycoon;

import dev.maalonsoa.engine.display.Display;
import dev.maalonsoa.engine.gfx.Assets;
import dev.maalonsoa.engine.gfx.ImageLoader;
import dev.maalonsoa.engine.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

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

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int scrWidth, int scrHeight) {
        this.title = title;
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        gameStatus = GameStatus.GAME_END;
    }

    private void init() {
        display = new Display(title, scrWidth, scrHeight);
        Assets.init();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, scrWidth, scrHeight);
        //Draw here
        g.drawImage(Assets.playerRun, 0, 0, null);
        g.drawImage(Assets.playerJump, 600, 0, null);
        //End draw
        bs.show();
        g.dispose();
    }

    private void tick() {
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
        if (gameStatus == GameStatus.GAME_ACTIVE) return;
        gameStatus = GameStatus.GAME_ACTIVE;
        thread = new Thread(this);
        thread.start();
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
