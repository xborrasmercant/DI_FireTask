package GUI;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.nio.Buffer;

public class FireAnimation extends BufferedImage {
    int width, height, posX, posY;
    Color customColor = new Color(255, 0, 128, 255);

    public FireAnimation(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        createFireImage(0, 0);

    }

    private void createFireImage(int x, int y) {


        setRGB(x, y, customColor.getRGB());
        System.out.println("Painted pixel at pos: (" + x + "," + y + ")");
    }

    public void next(int x, int y) {
        createFireImage(x, y);
    }
}