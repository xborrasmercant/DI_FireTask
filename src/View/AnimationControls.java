package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AnimationControls extends JPanel {
    public JToggleButton playPause;
    public JButton stopButton;
    public JButton applyButton;

    public AnimationControls(){
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);

        setPreferredSize(new Dimension(220,35));
        setLayout(new GridBagLayout());
        addButtonsToPane(this);
    }

    private void addButtonsToPane(Container panel) {
        // Animation control buttons are added to the panel.

        GridBagConstraints c = new GridBagConstraints();

        // Default configuration for buttons
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;

        this.playPause = new JToggleButton("Play");
        this.stopButton = new JButton("Stop");
        this.applyButton = new JButton("Apply");

        c.gridx = 0;
        c.gridy = 0;
        panel.add(this.playPause, c);

        c.gridx = 1;
        panel.add(this.applyButton, c);

        c.gridx = 1;
        panel.add(this.stopButton, c);


    }
}
