package game.pack;

import java.io.File;
import java.util.ArrayList;

public class LoadGenerateImages {

    private ArrayList<String> imageFiles;

    public LoadGenerateImages(String directoryPath) {
        imageFiles = new ArrayList<>();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        for (File f : files) {
            imageFiles.add(f.getPath());
        }
        System.out.println("Images loaded: " + imageFiles);
    }

    public String randomImageFilename() {
        int imageRandomNumber = (int) (Math.random() * imageFiles.size());
        String imageRandomFilename = imageFiles.get(imageRandomNumber);
        System.out.println("tyt" + imageRandomFilename); // random
        return imageRandomFilename;
    }

    public ArrayList<String> getImageFiles() {
        return imageFiles;
    }
}
