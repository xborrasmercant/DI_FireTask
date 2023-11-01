package CustomGUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.nio.file.DirectoryNotEmptyException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomTextField extends JTextField {

    public CustomTextField () {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setPreferredSize(new Dimension(50,20));
    }
}
