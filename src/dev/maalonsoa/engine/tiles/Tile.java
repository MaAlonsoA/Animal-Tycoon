package dev.maalonsoa.engine.tiles;

import dev.maalonsoa.animaltycoon.tiles.DirtTile;
import dev.maalonsoa.animaltycoon.tiles.GrassTile;
import dev.maalonsoa.animaltycoon.tiles.RockTile;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {
    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public static Tile [] tiles = new Tile[256];

    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public int getId() {
        return id;
    }

    public void tick() {

    }

    public abstract boolean isSolid();

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null );
    }
}
