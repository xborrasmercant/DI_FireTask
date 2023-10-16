package GUI;

import Logic.Palette;
import Logic.Temperature;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

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
        for (int y = foregroundImg.height-1 ; y < foregroundImg.height; y--) {
            for (int x = 0; x < foregroundImg.width; x++) {
                viewer.paintForeground(x, y);
            }
        }
    }

    public static void main(String[] args) {
        Palette palette = new Palette();
        Temperature tempsMap = new Temperature(10,10,0.3, 0.3);
        //FireTask mainWindow = new FireTask(650, 650);



        palette.addColourTarget(255, 255, 255, 255, 255); // Spark
        palette.addColourTarget(150, 255, 242, 125, 12); // ORANGE
        palette.addColourTarget(200, 255, 253, 207, 88); // YELLOW
        palette.addColourTarget(0, 0, 0, 0, 0);      // Transparency
        palette.addColourTarget(75, 255, 128, 9, 9);  // RED
        palette.sortColourTargets();
        //palette.printColourTargets();
        palette.calc();
        palette.printPalette();


        //mainWindow.playAnimation();



        while (true) {
            tempsMap.next();
        }
    }

}
