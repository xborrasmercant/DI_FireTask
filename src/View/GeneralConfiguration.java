package View;

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
        int insetAmount = 5;

        c.insets = new Insets(insetAmount, insetAmount, insetAmount, insetAmount);


        fireWidth = new JTextField("Enter width");
        fireHeight = new JTextField("Enter height");
        fireXPosition = new JTextField("Enter x position");
        fireYPosition = new JTextField("Enter y position");
        backgroundChooser = new JButton("Select Background");

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(fireWidth, c);

        c.gridx = 1;
        add(fireHeight, c);

        c.gridy = 1;
        c.gridx = 0;
        add(fireXPosition, c);

        c.gridx = 1;
        add(fireYPosition, c);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        add(backgroundChooser, c);









    }

}
