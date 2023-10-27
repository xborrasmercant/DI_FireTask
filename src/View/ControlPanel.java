package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ControlPanel extends JPanel {
    public AnimationControls controls;
    public GeneralConfiguration config;


    public ControlPanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);

        setBorder(blackBorder);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(350, 650));
        addElementsToControlPanel();
    }


    public void addElementsToControlPanel() {
        GridBagConstraints c = new GridBagConstraints();

        controls = new AnimationControls();
        config = new GeneralConfiguration();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        this.add(controls, c);

        c.gridy = 1;
        this.add(config, c);
    }
}
