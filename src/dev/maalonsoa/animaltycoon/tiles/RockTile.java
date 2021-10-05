package dev.maalonsoa.animaltycoon.tiles;

import dev.maalonsoa.engine.gfx.Assets;
import dev.maalonsoa.engine.tiles.Tile;

import java.awt.image.BufferedImage;

public class RockTile extends Tile {

    public RockTile( int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
