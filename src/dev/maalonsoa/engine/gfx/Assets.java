package dev.maalonsoa.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    public static BufferedImage grass;
    public static BufferedImage stone;
    public static BufferedImage dirt;

    public static BufferedImage[] playerDown;
    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerLeft;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        playerDown = new BufferedImage[2];
        playerDown[0] = sheet.crop(width * 4, 0, width, height);
        playerDown[1] = sheet.crop(width * 5, 0, width, height);

        playerUp = new BufferedImage[2];
        playerUp[0] = sheet.crop(width * 6, 0, width, height);
        playerUp[1] = sheet.crop(width * 7, 0, width, height);

        playerRight = new BufferedImage[2];
        playerRight[0] = sheet.crop(width * 4, height, width, height);
        playerRight[1] = sheet.crop(width * 5, height, width, height);

        playerLeft = new BufferedImage[2];
        playerLeft[0] = sheet.crop(width * 6, height, width, height);
        playerLeft[1] = sheet.crop(width * 7, height, width, height);

        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(0, height * 2, width, height);
        dirt = sheet.crop(width, 0, width, height);


    }
}
