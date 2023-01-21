package src;

import control.MainFrame;
import model.Image;
import persistence.FileImageLoader;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file = new File("persona5");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);

    }
}
