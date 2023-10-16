package GUI;

import Logic.Palette;
import Logic.Temperature;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.nio.Buffer;

public class FireAnimation extends BufferedImage {
    int width, height, posX, posY;
    private Temperature tempsMap;
    private Palette palette;


    public FireAnimation(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        tempsMap = new Temperature(260,380,0.3, 0.3);
        palette = new Palette();
    }

    private void createFireImage() {
        Color colour;
        for (int x = 0; x < tempsMap.width-1; x++) {
            for (int y = 0; y < tempsMap.height-1; y++) {
                colour = this.palette.colourPalette[tempsMap.temps[x][y]];
                setRGB(x, y, colour.getRGB());
                System.out.println("Painted pixel at pos: (" + x + "," + y + ")");
            }
        }
    }

    public void next() {
        createFireImage();
        tempsMap.next();
    }
}