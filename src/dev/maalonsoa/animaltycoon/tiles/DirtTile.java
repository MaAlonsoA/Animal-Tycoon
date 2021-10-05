package dev.maalonsoa.animaltycoon.tiles;

import dev.maalonsoa.engine.gfx.Assets;
import dev.maalonsoa.engine.tiles.Tile;

import java.awt.image.BufferedImage;

public class DirtTile extends Tile {
    public DirtTile(int id) {
        super(Assets.dirt, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
