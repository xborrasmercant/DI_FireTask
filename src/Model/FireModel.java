package Model;

import java.awt.image.BufferedImage;
import java.awt.*;


public class FireModel extends BufferedImage {
    public Temperature temps;
    public Palette pal;
    private int posX, posY;



    public FireModel(int width, int height, int posX, int posY) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        temps = new Temperature(width, height,0.3, 0.5);
        pal = new Palette();
        this.posX = posX;
        this.posY = posY;
        createFireImage();
        temps.next();

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    // Public methods:
    public void next() {

        temps.next(); // Siguiente iteracion de la matriz de temperaturas
        createFireImage();
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight()-1; j++) { // Pintada pixel a pixel en funcion de la temperatura
                this.setRGB(i, j, pal.colourPalette[temps.tempMap[j][i]].getRGB());
            }
        }

    }

    // Private methods:
    private void createFireImage() { // Crea la imagen transparente de inicio
        Color color = new Color(0, 0, 0, 0);

        try {
            for (int i = getHeight(); i < 0; i--) {
                for (int j = 0; j < this.getWidth(); j++) {
                    this.setRGB(i, j, color.getRGB());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}