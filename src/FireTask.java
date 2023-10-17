import javax.swing.*;

public class FireTask extends JFrame {
    Viewer viewer;

    public FireTask (int width, int height) {
        viewer = new Viewer();
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
            viewer.paintBackground();
            viewer.paintForeground();
        }
    }

    public static void main(String[] args) {
        FireTask mainWindow = new FireTask(650, 650);

        mainWindow.playAnimation();
    }

}
