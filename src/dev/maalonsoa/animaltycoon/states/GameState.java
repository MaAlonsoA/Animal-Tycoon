package dev.maalonsoa.animaltycoon.states;

import dev.maalonsoa.animaltycoon.Game;
import dev.maalonsoa.animaltycoon.Handler;
import dev.maalonsoa.animaltycoon.World;
import dev.maalonsoa.animaltycoon.entities.creatures.Player;
import dev.maalonsoa.engine.logic.State;

import java.awt.*;

public class GameState extends State {

    private final Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        player = new Player(handler, 400, 400);
        handler.setWorld(world);
        world = new World(handler, "res/worlds/world1.txt");
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
