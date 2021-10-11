package dev.maalonsoa.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    public static BufferedImage grass;
    public static BufferedImage stone;
    public static BufferedImage dirt;
    public static BufferedImage player;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(0, height * 2, width, height);
        dirt = sheet.crop(width, 0, width, height);
        player = sheet.crop(width * 4, 0, width, height);

    }
}
