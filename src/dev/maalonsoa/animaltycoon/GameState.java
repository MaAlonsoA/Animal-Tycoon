package dev.maalonsoa.animaltycoon;

import dev.maalonsoa.animaltycoon.entities.creatures.Player;
import dev.maalonsoa.engine.logic.State;
import dev.maalonsoa.engine.gfx.Assets;
import dev.maalonsoa.engine.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private final Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,400,400);
    }
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        Tile.tiles[0].render(g,0,0);
        Tile.tiles[2].render(g,0,0);
    }
}
