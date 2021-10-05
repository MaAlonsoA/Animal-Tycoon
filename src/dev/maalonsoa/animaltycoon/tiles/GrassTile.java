package dev.maalonsoa.animaltycoon.tiles;

import dev.maalonsoa.engine.gfx.Assets;
import dev.maalonsoa.engine.tiles.Tile;

public class GrassTile extends Tile {
    public GrassTile(int id) {
        super(Assets.grass, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
