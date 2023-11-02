package View;

import Model.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Viewer extends Canvas {
    public BufferedImage backgroundImg;
    public FireModel foregroundImg;
    public BufferStrategy bs;
    int fireWidth ;
    int fireHeight;
    int fireXPos;
    int fireYPos;

    public Viewer(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;
        setDefaultForegroundImage();
        this.bs = null;
        this.setPreferredSize(new Dimension(650,650));

    }

    @Override
    public void paint(Graphics g) {
        System.out.println("Overrided Paint()");
    }

    public void loadBackground(File backgroundFile) {
        // Background file is loaded from Resources folder.

        try {
            this.backgroundImg = ImageIO.read(backgroundFile);
            System.out.println("The background image has been loaded successfully.");

        }
        catch (IOException e) {
            System.out.println("An error occurred while loading the background: ");
            e.printStackTrace();
        }
    }
    /*public void paintElements() {
        // To use only the bufferStrategy when needed an if statement check if the canvas' bs is already null, in that case, a new bufferStrategy(2) is created.
        if (bs == null) {
            System.out.println("BufferStrategy does not exists, therefore one with two buffers will be created and assigned to bs.");
            this.createBufferStrategy(2);
            bs = getBufferStrategy();
        }

        // We get the Graphics manager from the bufferStrategy and use it to draw the background image.
        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.backgroundImg, 0, 0, backgroundImg.getWidth(), backgroundImg.getHeight(), null);
        g.drawImage(this.foregroundImg, (int) (this.getWidth()/2.45), (int) (this.getHeight()/1.95), (int) (this.getWidth()/2.15), (int) (this.getHeight()/3), null);
        this.foregroundImg.next();

        bs.show(); // We swap the back buffer with the display one to show the background image and the we release the resources from the graphics manager.
        g.dispose();
    }

     */

    public void paintBackground(){


        // To use only the bufferStrategy when needed an if statement check if the canvas' bs is already null, in that case, a new bufferStrategy(2) is created.
        if (bs == null) {
            System.out.println("BufferStrategy does not exists, therefore one with two buffers will be created and assigned to bs.");
            this.createBufferStrategy(2);
            bs = getBufferStrategy();
        }

        // We get the Graphics manager from the bufferStrategy and use it to draw the background image.
        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.backgroundImg, 0, 0, this.getWidth(), this.getHeight(), null);


        bs.show(); // We swap the back buffer with the display one to show the background image and the we release the resources from the graphics manager.
        g.dispose();
    }

    public void paintForeground(){

        fireWidth = this.foregroundImg.getWidth();
        fireHeight = this.foregroundImg.getHeight();
        fireXPos = this.foregroundImg.getPosX();
        fireYPos = this.foregroundImg.getPosY();

        // To use only the bufferStrategy when needed an if statement check if the canvas' bs is already null, in that case, a new bufferStrategy(2) is created.
        if (bs == null) {
            System.out.println("BufferStrategy does not exists, therefore one with two buffers will be created and assigned to bs.");
            this.createBufferStrategy(2);
            bs = getBufferStrategy();
        }

        // We get the Graphics manager from the bufferStrategy and use it to draw the background image.
        Graphics g = bs.getDrawGraphics();

        g.drawImage(this.foregroundImg, fireXPos, fireYPos, fireWidth, fireHeight, null);
        this.foregroundImg.next();

        bs.show(); // We swap the back buffer with the display one to show the background image and the we release the resources from the graphics manager.
        g.dispose();
//
    }

    public void setDefaultForegroundImage() {
        fireWidth = 290;
        fireHeight = 130;
        fireXPos = 270;
        fireYPos = 400;
    }

}
