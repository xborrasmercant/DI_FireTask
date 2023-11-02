package Controller;

import View.*;
import Model.*;

import static java.lang.Thread.sleep;

public class FireController {
    protected FireModel foregroundImg;
    protected FireView FView;
    DTOGeneralParameters gpDTO;

    public FireController () {
        foregroundImg = new FireModel(290, 335, 270, 200);

        FView = new FireView(foregroundImg);
    }

    public void playAnimation() {


        while (true) {
            if (FView.v.backgroundImg != null) {
                FView.v.paintBackground();
            }
            if (FView.getPlayButton().isSelected()) {
                FView.v.paintForeground();
            }
            if (FView.getInvertButton().isSelected()) {
                FView.v.foregroundImg.getTemps().setIsInverted(true);
                System.out.println("Inverted Fire");
            }
            else {
                FView.v.foregroundImg.getTemps().setIsInverted(false);
                System.out.println("Uninverted Fire");
            }

            try {
                sleep(50);
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