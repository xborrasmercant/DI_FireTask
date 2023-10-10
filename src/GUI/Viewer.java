package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Viewer extends Canvas {
    BufferedImage backgroundImg;
    BufferStrategy bs;

    public Viewer () {
        loadBackground();
        setSize(backgroundImg.getWidth(), backgroundImg.getHeight());
        setVisible(true);
    }



    private void loadBackground() {
        try {
            backgroundImg = ImageIO.read(new File("C:\\Users\\chabo\\Documents\\Java\\Proyectos\\FireTask\\src\\Resources\\bg.jpg"));
            System.out.println("The background image has been loaded successfully.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while loading the background: ");
            e.printStackTrace();
        }
    }

    public void paintBackground(){
        //We create a double buffer and assign it to the Viewer's bufferStrategy object.
        this.createBufferStrategy(2);
        bs = this.getBufferStrategy();

        Graphics g = bs.getDrawGraphics();
        g.drawImage(backgroundImg, 0, 0, backgroundImg.getWidth(), backgroundImg.getHeight(), null);

        bs.show(); // We change swap the back buffer with the display one to show the background image.
        g.dispose(); // Graphics resources are released.
    }

    public void paintForeground(){
        //
    }

}
