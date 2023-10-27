package Model;

import java.awt.image.BufferedImage;
import java.awt.*;


public class FireModel extends BufferedImage {
    public Temperature temps;
    public Palette pal;



    public FireModel(int width, int height) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        temps = new Temperature(width, height,0.3, 0.5);
        pal = new Palette();

        createFireImage();
        temps.next();

    }


    // Public methods:
    public void next() {

        temps.next(); // Siguiente iteraci贸n de la matriz de temperaturas
        createFireImage();
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight()-1; j++) { // Pintada pixel a pixel en funci贸n de la temperatura
                //System.out.println(pal.colourPalette[temps.tempMap[j][i]]);



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
                    System.out.println(i +" "+ j);
                    this.setRGB(i, j, color.getRGB());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}