package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import static java.lang.Thread.sleep;

public class FireView extends JFrame implements ActionListener, ComponentListener {
    public Viewer v;
    public FireModel foregroundImg;
    public ControlPanel controlPanel;
    public DTOGeneralParameters gp;

    public FireView(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;

        configureFrame();
        addUIComponents();
        v.defaultForegroundImage();

        setVisible(true);
        pack();
        setLocationRelativeTo(null); // Window will appear at the center of the screen.

    }

    private void addControlsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;

        controlPanel = new ControlPanel();
        panel.add(controlPanel, c);
    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

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
        getApplyButton().addActionListener(this);
        getDefaultButton().addActionListener(this);

    }

    private void configureFrame() {
        setLayout(new GridBagLayout());
        setTitle("Randomized Fire");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.

    }
    public JToggleButton getPlayButton() {
        return controlPanel.controls.playPause;
    }
    public JButton getStopButton() {
        return controlPanel.controls.stopButton;
    }
    public JButton getApplyButton() {
        return controlPanel.controls.applyButton;
    }
    public JButton getBGButton() {
        return controlPanel.config.backgroundChooser;
    }
    public JButton getDefaultButton() {
        return controlPanel.controls.defaultButton;
    }
    public String getFireWidth() {
        return controlPanel.config.fireWidth.getText();
    }
    public String getFireHeight() {
        return controlPanel.config.fireHeight.getText();
    }
    public String getFireXPos() {
        return controlPanel.config.fireXPosition.getText();
    }
    public String getFireYPos() {
        return controlPanel.config.fireYPosition.getText();
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
            case "Default":
                v.foregroundImg = new FireModel(290, 335, 270, 200);

                System.out.println("Default properties have been reset");
                break;
            case "Apply":
                int fireWidth = Integer.parseInt(getFireWidth());
                int fireHeight = Integer.parseInt(getFireHeight());
                int fireXPos = Integer.parseInt(getFireXPos());
                int fireYPos = Integer.parseInt(getFireYPos());
                System.out.println("W: " + fireWidth + " | H: " + fireHeight + " | X: " + fireXPos + " | Y: " + fireYPos);

                v.foregroundImg = new FireModel(fireWidth, fireHeight, fireXPos, fireYPos);
                //gp = new DTOGeneralParameters(fireWidth, fireHeight, fireXPos, fireYPos);


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

    @Override
    public void componentResized(ComponentEvent e) {
        e.getComponent();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("Hola");
    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println("Hola");

    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("Hola");

    }
}
