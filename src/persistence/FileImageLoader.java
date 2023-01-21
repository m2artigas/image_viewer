package persistence;

import model.Image;

import java.io.*;

public class FileImageLoader implements ImageLoader {

    public File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(imageTypes());
    }

    public FileFilter imageTypes() {
        return new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                System.out.println(pathname.getName());
                return pathname.getName().endsWith(".jpg");
            }
        };
    }

    public Image imageAt(int i) {
        return new Image() {
            @Override
            public String name(){
                return files[i].getName();
            }

            @Override
            public InputStream stream(){
                try {
                    return new BufferedInputStream(new FileInputStream(files[i]));
                } catch (FileNotFoundException e) {
                    return null;
                }
            }

            @Override
            public Image next() {
                return i == files.length -1 ? imageAt(0) : imageAt(i+1);
            }

            @Override
            public Image prev(){
                return i == 0 ? imageAt(files.length-1) : imageAt(i-1);
            }
        };
    }

    @Override
    public Image load() {
        return imageAt(0);
    }
}
