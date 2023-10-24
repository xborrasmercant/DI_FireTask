import javax.swing.*;

public class FireView  extends JFrame {
    Viewer v;
    FireModel foregroundImg;

    public FireView(){
        configureFrame(650, 650);
    }

    public void loadForeground(FireModel fore) {
        foregroundImg = fore;
        v = new Viewer(foregroundImg);
        add(v);

    }

    private void addUIElements() {
        v = new Viewer(foregroundImg);
        add(v);
    }

    private void configureFrame(int width, int height) {
        setSize(width, height);
        setTitle("Randomized Fire");
        setLocationRelativeTo(null); // Window will appear at the center of the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closing the window stops the program.
        setResizable(false);
        setVisible(true);
    }

}
