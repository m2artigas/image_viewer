package ui;

import model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay{

    public Image currentImage;

    @Override
    public void paint(Graphics g){
        if (currentImage == null) return;
        g.drawImage(imageOf(currentImage), 0, 0, null);
    }

    private java.awt.Image imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.repaint();
    }
}
