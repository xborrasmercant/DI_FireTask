package View;

import CustomGUI.CustomTextField;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class GeneralConfiguration extends JPanel {
    public JTextField fireWidth;
    public JTextField fireHeight;
    public JTextField fireXPosition;
    public JTextField fireYPosition;
    public JButton backgroundChooser;
    public BufferedImage backgroundImage;
    //public JTextField showFramesPerSecond;
    //public JTextField calcFramesPerSecond;

    public GeneralConfiguration() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);

        setBorder(blackBorder);
        setLayout(new GridBagLayout());
        addFieldsToPanel();

    }

    public void addFieldsToPanel() {
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(5, 5, 5, 5);
        JLabel widthLabel = new JLabel("Width:");
        JLabel heightLabel = new JLabel("Height:");
        JLabel XPosLabel = new JLabel("X Pos:");
        JLabel YPosLabel = new JLabel("Y Pos:");


        fireWidth = new JTextField();
        fireHeight = new JTextField();
        fireXPosition = new JTextField();
        fireYPosition = new JTextField();
        backgroundChooser = new JButton("Select Background");
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(widthLabel, c);

        c.gridx = 1;
        add(fireWidth, c);

        c.gridx = 2;
        add(heightLabel, c);

        c.gridx = 3;
        add(fireHeight, c);

        c.gridy = 1;
        c.gridx = 0;
        add(XPosLabel, c);

        c.gridx = 1;
        add(fireXPosition, c);

        c.gridx = 2;
        add(YPosLabel, c);

        c.gridx = 3;
        add(fireYPosition, c);

        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 2;
        add(backgroundChooser, c);
    }

}
