package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationControls extends JPanel implements ActionListener {

    public JButton playPause;
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

        this.playPause = new JButton("Play");
        this.playPause.addActionListener(this);
        panel.add(this.playPause, c);

        c.gridy = 1;
        this.stopButton = new JButton("Stop");
        this.stopButton.addActionListener(this);
        panel.add(this.stopButton, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                System.out.println("Play");
                resume = true;
                break;
            case "Stop":
                System.out.println("Stop");
                resume = false;
                break;
            case "Apply":
                System.out.println("Apply");
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }
}
