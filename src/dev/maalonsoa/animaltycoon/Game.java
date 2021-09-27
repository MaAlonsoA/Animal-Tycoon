package dev.maalonsoa.animaltycoon;

import dev.maalonsoa.animaltycoon.states.MenuState;
import dev.maalonsoa.engine.input.KeyManager;
import dev.maalonsoa.engine.logic.State;
import dev.maalonsoa.engine.display.Display;
import dev.maalonsoa.engine.gfx.Assets;

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

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;
    private KeyManager keyManager;

    public Game(String title, int scrWidth, int scrHeight) {
        this.title = title;
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        gameStatus = GameStatus.GAME_END;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, scrWidth, scrHeight);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        
        State.setState(gameState);
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
        if (State.getState() != null){
            State.getState().render(g);
        }

        //End draw
        bs.show();
        g.dispose();
    }

    int x = 0;
    int y = 0;

    private void tick() {
        if (State.getState() != null){
            State.getState().tick();
        }
    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (gameStatus != GameStatus.GAME_END) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
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
