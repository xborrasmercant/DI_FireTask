package Controller;

import View.*;
import Model.*;

import static java.lang.Thread.sleep;

public class FireController {
    protected FireModel foregroundImg;
    protected FireView FView;

    public FireController () {
        foregroundImg = new FireModel(290, 120);
        FView = new FireView(foregroundImg);

    }

    public void playAnimation() {
        while (true) {
            if (FView.getPlayButton().isSelected()) {
                FView.v.paintElements();
                // Animation is played
            }

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
