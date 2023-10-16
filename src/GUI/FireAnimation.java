package GUI;

import java.awt.image.BufferedImage;
import java.awt.*;
public class FireAnimation extends BufferedImage {
    int width, height, posX, posY;

    public FireAnimation(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_RGB);
        this.posX = posX;
        this.posY = posY;
        createFireImage();
    }

    private void createFireImage() {
        this.setRGB(10, 30, 0xFF00FF);
        System.out.println("Pixel painted");
    }

    public void next() {
        createFireImage();
    }
}