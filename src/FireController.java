

import static java.lang.Thread.sleep;

public class FireController {
    FireModel foregroundImg;
    FireView FView;


    public FireController () {
        foregroundImg = new FireModel(290, 120);
        FView = new FireView();

        FView.loadForeground(foregroundImg);
    }

    public void playAnimation() {
        while (true) {
            FView.v.paintElements();

            try {
                sleep(20);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        FireController mainWindow = new FireController();
        mainWindow.playAnimation();
    }
}
