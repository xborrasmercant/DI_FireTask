import java.awt.image.BufferedImage;
import java.awt.*;
import java.nio.Buffer;

public class FireAnimation extends BufferedImage {
    int width, height, posX, posY;
    Temperature temps;
    Palette pal;

    public FireAnimation(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        temps = new Temperature(width, height,0.1, 0.1);
        pal = new Palette();

        this.posX = posX;
        this.posY = posY;
    }

    private void createFireImage() {
        Color nextColor;

        // The finishing of the two for loops represents 1 frame
        for (int y = height-1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                nextColor = pal.colourPalette[temps.tempMap[x][y]]; // Next color is equal to the color according to tempsMap.
                setRGB(x, y, nextColor.getRGB());
            }
        }
    }

    public void next() {
        this.createFireImage();
        this.temps.next();
    }
}