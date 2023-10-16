package GUI;

import java.awt.image.BufferedImage;

public class FireAnimation extends BufferedImage {
    int width, height, posX, posY;

    public FireAnimation(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        this.posX = posX;
        this.posY = posY;
    }

    private void createFireImage() {
        this.setRGB(posX, posY, 2000);
        this.posX ++;
        this.posY ++;
    }

    public void next() {
        createFireImage();
    }
}