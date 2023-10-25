package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationControls extends JPanel {

    public JToggleButton playPause;
    public JButton stopButton;
    public boolean resume = false;

    public AnimationControls(){
        addButtonsToPane(this);
    }

    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;

        this.playPause = new JToggleButton("Play");
        panel.add(this.playPause, c);


        c.gridy = 1;
        this.stopButton = new JButton("Stop");
        panel.add(this.stopButton, c);
    }
}
