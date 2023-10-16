package GUI;

import Logic.Palette;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.nio.Buffer;

public class FireAnimation extends BufferedImage {
    int width, height, posX, posY;

    public FireAnimation(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_RGB);
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
    }

    public void createFireImage(int x, int y, int actualTemp) {
        Palette palette = new Palette();
        Color colour;

        colour = new Color(palette.colourPalette[actualTemp].getRGB());

        setRGB(x, y, colour.getRGB());
        System.out.println("Painted pixel at pos: (" + x + "," + y + ")");
    }
}