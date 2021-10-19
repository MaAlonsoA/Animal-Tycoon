package dev.maalonsoa.animaltycoon;

import dev.maalonsoa.engine.camera.GameCamera;
import dev.maalonsoa.engine.input.KeyManager;

public class Handler {

    private Game game;
    private World world;


    public Handler(Game game, World world) {
        this.game = game;
    }

    public int getScrWidth() {
        return game.getScrWidth();
    }

    public int getScrHeight() {
        return game.getScrHeight();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
