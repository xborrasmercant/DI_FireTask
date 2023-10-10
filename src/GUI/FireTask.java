package GUI;

import Logic.Palette;
import Logic.Temperature;

import javax.swing.*;
import java.awt.event.*;

public class FireTask extends JFrame {

    public FireTask (int width, int height) {
        Viewer background = new Viewer();

        add(background);
        setSize(width, height);
        configureFrame();
        background.createBufferStrategy(2);
        background.paintBackground();


    }

    private void configureFrame() {
        setTitle("Randomized Fire");
        setLocationRelativeTo(null); // Window will appear at the center of the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
    }

    public static void main(String[] args) {
        Palette palette = new Palette();
        Temperature tempsMap = new Temperature(5,5,0.3, 0.3);
        FireTask mainWindow = new FireTask(1000, 750);

        mainWindow.setVisible(true);











        palette.addColourTarget(255, 255, 255, 255, 255); // Spark
        palette.addColourTarget(150, 255, 242, 125, 12); // ORANGE
        palette.addColourTarget(200, 255, 253, 207, 88); // YELLOW
        palette.addColourTarget(0, 0, 0, 0, 0);      // Transparency
        palette.addColourTarget(75, 255, 128, 9, 9);  // RED
        palette.sortColourTargets();
        //palette.printColourTargets();
        palette.calc();
        //palette.printPalette();

        //while (true) {
        //    tempsMap.next();
        //}
    }

}
