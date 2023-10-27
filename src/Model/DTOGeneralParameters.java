package Model;

import java.awt.image.BufferedImage;

public class DTOGeneralParameters {
    private int fireWidth;
    private int fireHeight;
    private int fireXPosition;
    private int fireYPositon;
    private BufferedImage backgroundImage;

    public DTOGeneralParameters(int fireWidth, int fireHeight, int fireXPosition, int fireYPositon, BufferedImage backgroundImage) {
        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;
        this.fireXPosition = fireXPosition;
        this.fireYPositon = fireYPositon;
        this.backgroundImage = backgroundImage;
    }
}
