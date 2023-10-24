package View;

import Model.*;

import javax.swing.*;
import java.awt.*;

public class FireView  extends JFrame {
    public Viewer v;
    public FireModel foregroundImg;

    public FireView(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;
        configureFrame(650, 650);
        addUIElements();

        setVisible(true);
        pack();
    }

    private void addUIElements() {
        v = new Viewer(foregroundImg);
        add(v);
    }

    private void configureFrame(int width, int height) {
        setLayout(new GridBagLayout());
        setSize(width, height);
        setTitle("Randomized Fire");
        setLocationRelativeTo(null); // Window will appear at the center of the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
        setResizable(false);
    }

}
