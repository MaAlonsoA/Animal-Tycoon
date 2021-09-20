package dev.maalonsoa.animaltycoon;

public class Launcher {
    public static void main(String[] args) {
        final int scrWidth = 1920;
        final int scrHeight = 1080;
        Game game = new Game("Animal Tycoon", scrWidth, scrHeight);
        game.start();
    }
}
