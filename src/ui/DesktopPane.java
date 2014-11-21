package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class DesktopPane extends JDesktopPane {

    BufferedImage backgroundImage;

    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        if (backgroundImage == null) {
            try {
                backgroundImage = ImageIO.read(new File("logo.png"));
            } catch (IOException ex) {
                Logger.getLogger(DesktopPane.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        int iw = backgroundImage.getWidth();
        int ih = backgroundImage.getHeight();

        int dw = getWidth();
        int dh = getHeight();

        float scale = Math.min(1.0f * dw / iw, 1.0f * dh / ih);

        int siw = (int) (scale * iw);
        int sih = (int) (scale * ih);

        int x = (dw - siw) / 2;
        int y = (dh - sih) / 2;

        grphcs.drawImage(backgroundImage, x, y, siw, sih, null);
    }
}
