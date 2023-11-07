package View;

import CustomGUI.CustomTextField;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TemperatureConfiguration extends JPanel {
    private JSlider newCoolPixelsPercentage;
    private JSlider newHotPixelsPercentage;
    //private JTable cellsPonderation;
    private JTextField cellsDivider;
    private JTextField fixAtenuationFactor;
    private JToggleButton buttonUpTemps;


    public TemperatureConfiguration() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);

        setBorder(blackBorder);
        setLayout(new GridBagLayout());
        addFieldsToPanel();

    }

    public JSlider getNewCoolPixelsPercentage() {
        return newCoolPixelsPercentage;
    }
    public JSlider getNewHotPixelsPercentage() {
        return newHotPixelsPercentage;
    }
    public JTextField getCellsDivider() {
        return cellsDivider;
    }
    public JTextField getFixAtenuationFactor() {
        return fixAtenuationFactor;
    }
    public JToggleButton getButtonUpTemps() {
        return buttonUpTemps;
    }

    public void addFieldsToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        int insetAmount = 5;

        c.insets = new Insets(insetAmount, insetAmount, insetAmount, insetAmount);

        newCoolPixelsPercentage = new JSlider(0,100);
        newHotPixelsPercentage  = new JSlider(0,100);
        //cellsPonderation;
        cellsDivider = new JTextField();
        fixAtenuationFactor = new JTextField();
        buttonUpTemps = new JToggleButton("Invert");

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;


        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        add(newCoolPixelsPercentage, c);

        c.gridx = 1;
        add(newHotPixelsPercentage, c);

        c.gridx = 0;
        c.gridy = 1;
        add(cellsDivider, c);

        c.gridx = 1;
        add(fixAtenuationFactor, c);

        c.fill = 0;

        c.gridwidth = 2;
        c.gridy = 2;
        c.gridx = 0;
        add(buttonUpTemps, c);

    }
}
