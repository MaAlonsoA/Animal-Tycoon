package dev.maalonsoa.animaltycoon;

public class Game {

    private Display display;

    public Game(String title, int width, int height) {
        display = new Display(title, width, height);
    }
}
