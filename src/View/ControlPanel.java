package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ControlPanel extends JPanel {
    public AnimationControls controls;
    public GeneralConfiguration generalConfig;
    public TemperatureConfiguration tempConfig;


    public ControlPanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);

        setBorder(blackBorder);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400, 650));
        addElementsToControlPanel();
    }


    public void addElementsToControlPanel() {
        GridBagConstraints c = new GridBagConstraints();
        int insetAmount = 2;

        c.insets = new Insets(2, 10, 2, 10);

        controls = new AnimationControls();
        generalConfig = new GeneralConfiguration();
        tempConfig = new TemperatureConfiguration();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.add(controls, c);

        c.gridy = 1;
        this.add(generalConfig, c);

        c.gridy = 2;
        this.add(tempConfig, c);
    }
}
