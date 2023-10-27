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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        CustomTextField textField1 = new CustomTextField();
        CustomTextField textField2 = new CustomTextField();
        CustomTextField textField3 = new CustomTextField();
        frame.setTitle("Button Test");
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.setSize(500,500);

        frame.setVisible(true);
    }
}
