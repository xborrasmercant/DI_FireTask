
import javax.swing.*;

import static java.lang.Thread.sleep;

public class FireTask extends JFrame {
    Viewer viewer;
    FireAnimation foregroundImg = new FireAnimation(290, 120, 50, 50);

    public FireTask (int width, int height) {
        viewer = new Viewer(foregroundImg);
        add(viewer);
        setSize(width, height);
        configureFrame();
        setVisible(true);
    }

    private void configureFrame() {
        setTitle("Randomized Fire");
        setLocationRelativeTo(null); // Window will appear at the center of the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
    }

    public void playAnimation() {
        while (true) {
                this.viewer.paintBackground();
                this.viewer.paintForeground();

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        FireTask mainWindow = new FireTask(650, 650);
        mainWindow.playAnimation();
    }
}
