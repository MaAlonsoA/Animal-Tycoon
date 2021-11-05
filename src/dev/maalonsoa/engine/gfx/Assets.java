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

        SpriteSheet pathTile = new SpriteSheet(ImageLoader.loadImage("/textures/path_autotile.png"));
        SpriteSheet waterTile = new SpriteSheet(ImageLoader.loadImage("/textures/spring_water.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/char1_walk.png"));
        SpriteSheet grassSheet = new SpriteSheet(ImageLoader.loadImage("/textures/summer_grass_soil.png"));


        playerDown = new BufferedImage[8];
        playerDown[0] = playerSheet.crop(0, 0, width, height);
        playerDown[1] = playerSheet.crop(width, 0, width, height);
        playerDown[2] = playerSheet.crop(width * 2, 0, width, height);
        playerDown[3] = playerSheet.crop(width * 3, 0, width, height);
        playerDown[4] = playerSheet.crop(width * 4, 0, width, height);
        playerDown[5] = playerSheet.crop(width * 5, 0, width, height);
        playerDown[6] = playerSheet.crop(width * 6, 0, width, height);
        playerDown[7] = playerSheet.crop(width * 7, 0, width, height);

        playerUp = new BufferedImage[8];
        playerUp[0] = playerSheet.crop(0, height, width, height);
        playerUp[1] = playerSheet.crop(width, height, width, height);
        playerUp[2] = playerSheet.crop(width * 2, height, width, height);
        playerUp[3] = playerSheet.crop(width * 3, height, width, height);
        playerUp[4] = playerSheet.crop(width * 4, height, width, height);
        playerUp[5] = playerSheet.crop(width * 5, height, width, height);
        playerUp[6] = playerSheet.crop(width * 6, height, width, height);
        playerUp[7] = playerSheet.crop(width * 7, height, width, height);

        playerRight = new BufferedImage[8];
        playerRight[0] = playerSheet.crop(0, height * 2, width, height);
        playerRight[1] = playerSheet.crop(width, height * 2, width, height);
        playerRight[2] = playerSheet.crop(width * 2, height * 2, width, height);
        playerRight[3] = playerSheet.crop(width * 3, height * 2, width, height);
        playerRight[4] = playerSheet.crop(width * 4, height * 2, width, height);
        playerRight[5] = playerSheet.crop(width * 5, height * 2, width, height);
        playerRight[6] = playerSheet.crop(width * 6, height * 2, width, height);
        playerRight[7] = playerSheet.crop(width * 7, height * 2, width, height);

        playerLeft = new BufferedImage[8];
        playerLeft[0] = playerSheet.crop(0, height * 3, width, height);
        playerLeft[1] = playerSheet.crop(width, height * 3, width, height);
        playerLeft[2] = playerSheet.crop(width * 2, height * 3, width, height);
        playerLeft[3] = playerSheet.crop(width * 3, height * 3, width, height);
        playerLeft[4] = playerSheet.crop(width * 4, height * 3, width, height);
        playerLeft[5] = playerSheet.crop(width * 5, height * 3, width, height);
        playerLeft[6] = playerSheet.crop(width * 6, height * 3, width, height);
        playerLeft[7] = playerSheet.crop(width * 7, height * 3, width, height);


        grass = grassSheet.crop(112, height / 2, width / 2, height / 2);
        stone = waterTile.crop(112, height / 2, width / 2, height / 2);
        dirt = pathTile.crop(112, height / 2, width / 2, height / 2);

    }
}
