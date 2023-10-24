package View;

import javax.swing.*;

public class ControlPanel extends JPanel {
    public AnimationControls controls = new AnimationControls();

    public ControlPanel() {
        add(controls);
    }
}
