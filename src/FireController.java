
import javax.swing.*;

import static java.lang.Thread.sleep;

public class FireController extends JFrame {
    Viewer viewer;
    FireModel foregroundImg;


    public FireController (int width, int height) {
        foregroundImg = new FireModel(290, 120);
        viewer = new Viewer(foregroundImg);
        add(viewer);
        setSize(width, height);
        configureFrame();
        setResizable(false);
        setVisible(true);
    }

    private void configureFrame() {
        setTitle("Randomized Fire");
        setLocationRelativeTo(null); // Window will appear at the center of the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
    }

    public void playAnimation() {
        while (true) {
                this.viewer.paintElements();

            try {
                sleep(20);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        FireController mainWindow = new FireController(650, 650);
        mainWindow.playAnimation();
    }
}
