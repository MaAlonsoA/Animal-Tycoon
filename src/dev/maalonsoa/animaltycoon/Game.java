package dev.maalonsoa.animaltycoon;

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
