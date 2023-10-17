import java.awt.image.BufferedImage;
import java.awt.*;
import java.nio.Buffer;

public class FireAnimation extends BufferedImage {
    int fireWidth, fireHeight, posX, posY;
    Temperature temps;
    Palette pal;

    public FireAnimation(int fireWidth, int fireHeight, int posX, int posY) {
        super(fireWidth, fireHeight, BufferedImage.TYPE_INT_ARGB);
        temps = new Temperature(fireWidth, fireHeight,0.1, 0.1);
        pal = new Palette();

        pal.calc();


        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;
        this.posX = posX;
        this.posY = posY;
    }

    private void createFireImage() {
        Color nextColor;

        // The finishing of the two for loops represents 1 frame
        for (int y = fireHeight-1; y >= 0; y--) {
            for (int x = 0; x < fireWidth; x++) {
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