package dev.maalonsoa.animaltycoon;

import dev.maalonsoa.animaltycoon.entities.creatures.Player;
import dev.maalonsoa.engine.logic.State;

import java.awt.*;

public class GameState extends State {

    private final Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 400, 400);
        world = new World(game, "res/worlds/world1.txt");
    }

    @Override
    public void tick() {
        player.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
