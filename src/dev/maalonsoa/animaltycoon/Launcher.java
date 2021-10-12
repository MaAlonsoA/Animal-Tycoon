package dev.maalonsoa.animaltycoon;

public class Launcher {
    public static void main(String[] args) {
        final int scrWidth = 640;
        final int scrHeight = 480;
        Game game = new Game("Animal Tycoon", scrWidth, scrHeight);
        game.start();
    }
}
