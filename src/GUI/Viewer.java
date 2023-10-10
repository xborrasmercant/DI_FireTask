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

    public Viewer(int pixWidth, int pixHeight) {
        Dimension d = new Dimension(pixWidth, pixHeight);
        this.setPreferredSize(d);
        this.loadBackground();
        this.bs = null;
        setVisible(true);

    }


    private void loadBackground() {
        try {
            backgroundImg = ImageIO.read(new File("src/Resources/bg.jpg"));
            System.out.println("The background image has been loaded successfully.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while loading the background: ");
            e.printStackTrace();
        }
    }

    public void paintBackground(){
        //We create a double buffer and assign it to the Viewer's bufferStrategy object.
        if (this.bs == null) {
            System.out.println("kgd");
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.backgroundImg, 0, 0, this.getWidth(), this.getHeight(), null);

        bs.show(); // We change swap the back buffer with the display one to show the background image.
        g.dispose(); // Graphics resources are released.
    }

    public void paintForeground(){
        //
    }

}
