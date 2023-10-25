package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FireView extends JFrame implements ActionListener {
    public Viewer v;
    public FireModel foregroundImg;
    public ControlPanel controlPanel;

    public FireView(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;

        configureFrame(1200, 650);
        addUIComponents();
        setVisible(true);
        pack();
    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;

        v = new Viewer(foregroundImg);
        panel.add(v, c);
    }

    private void addControlsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;

        controlPanel = new ControlPanel();
        panel.add(controlPanel, c);
    }

    private void addUIComponents() {
        Container panel = this.getContentPane();

        addViewerToPane(panel);
        addControlsToPane(panel);

        getPlayButton().addActionListener(this);
        getStopButton().addActionListener(this);
    }

    private void configureFrame(int width, int height) {
        setLayout(new GridBagLayout());
        setSize(width, height);
        setTitle("Randomized Fire");
        setLocationRelativeTo(null); // Window will appear at the center of the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
        //setResizable(false);
    }

    public JToggleButton getPlayButton() {
        return controlPanel.controls.playPause;
    }

    public JButton getStopButton() {
        return controlPanel.controls.stopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                System.out.println("Play");
                break;
            case "Stop":
                System.out.println("Stop");
                System.exit(0);

                break;
            case "Apply":
                System.out.println("Apply");
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }
}
