package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static java.lang.Thread.sleep;

public class FireView extends JFrame implements ActionListener {
    public Viewer v;
    public FireModel foregroundImg;
    public ControlPanel controlPanel;


    public FireView(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;

        configureFrame();
        addUIComponents();

        setVisible(true);
        pack();
        setLocationRelativeTo(null); // Window will appear at the center of the screen.

    }

    private void addControlsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;

        controlPanel = new ControlPanel(300, 300);
        panel.add(controlPanel, c);
    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 0;

        v = new Viewer(foregroundImg);
        panel.add(v, c);
    }

    private void addUIComponents() {
        Container panel = this.getContentPane();

        addViewerToPane(panel);
        addControlsToPane(panel);

        getPlayButton().addActionListener(this);
        getStopButton().addActionListener(this);
        getBGButton().addActionListener(this);

    }

    private void configureFrame() {
        setLayout(new GridBagLayout());
        setTitle("Randomized Fire");
        setPreferredSize(new Dimension(1000 , 1000));
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.

    }

    public JToggleButton getPlayButton() {
        return controlPanel.controls.playPause;
    }
    public JButton getStopButton() {
        return controlPanel.controls.stopButton;
    }
    public JButton getBGButton() {
        return controlPanel.config.backgroundChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                System.out.println("Animation has been Resumed/Paused");
                break;
            case "Stop":
                // App is closed before 1 second.

                try {
                    System.out.println("Terminating fire... ");
                    sleep(1000);
                    System.exit(0);

                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Apply":
                // change config

                break;
            case "Select Background":
                JFileChooser chooser = new JFileChooser(new File("src/Resources/bg.jpg"));
                int selection;
                File selectedFile;

                System.out.println("Selecting background");
                selection = chooser.showOpenDialog(this);

                if (selection == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    v.loadBackground(selectedFile);
                    v.paintBackground();
                }


                break;
            default:
                System.err.println("Not treated action: " + e);
        }
    }
}
