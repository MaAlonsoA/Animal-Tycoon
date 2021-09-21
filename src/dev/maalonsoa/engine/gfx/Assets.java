package dev.maalonsoa.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 614, height = 564;
    public static BufferedImage playerDead, playerIdle, playerIdle2, playerJump, playerRun;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/1.png"));

        playerDead = sheet.crop(0, 0, width, height);
        playerIdle = sheet.crop(width, 0, width, height);
        playerIdle2 = sheet.crop(width * 2, 0, width, height);
        playerJump = sheet.crop(0, height, width, height);
        playerRun = sheet.crop(width, height, width, height);
    }
}
