package game.pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label outputLabel1;

    @FXML
    private Label outputLabel2;

    @FXML
    private Label outputLabel3;

    @FXML
    private Button generateBtn;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    private ArrayList<String> imageFiles;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadImages("Game/src/images/");
    }

    @FXML
    void showReels(ActionEvent event) {
        Game game = new Game();

        outputLabel1.setText(game.generate());
        outputLabel2.setText(game.generate());
        outputLabel3.setText(game.generate());

        image1.setImage(new Image(new File(randomImageFilename()).toURI().toString()));
        image2.setImage(new Image(new File(randomImageFilename()).toURI().toString()));
        image3.setImage(new Image(new File(randomImageFilename()).toURI().toString()));

    }

    private void loadImages(String directoryPath) {
        imageFiles = new ArrayList<>();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        for (File f : files) {
            imageFiles.add(f.getPath());
        }
        System.out.println("Images loaded: " + imageFiles);
    }

    private String randomImageFilename() {
        int imageRandomNumber = (int) (Math.random() * imageFiles.size());
        String imageRandomFilename = imageFiles.get(imageRandomNumber);
        System.out.println(imageRandomFilename); // random
        return imageRandomFilename;
    }

}
