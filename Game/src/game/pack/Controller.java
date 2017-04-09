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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        File file = new File("Game/src/images/test_image.png");
//        Image image = new Image(file.toURI().toString());
//        imageView1.setImage(image);
    }

    @FXML
    void showReels(ActionEvent event) {
        Game game = new Game();

        outputLabel1.setText(game.generate());
        outputLabel2.setText(game.generate());
        outputLabel3.setText(game.generate());

        ArrayList<String> imageFiles = new ArrayList<>();
        File directory = new File("Game/src/images");

        File[] files = directory.listFiles();
        for (File f : files) {
            imageFiles.add(f.getName());
        }
        System.out.println(imageFiles);
        int imageRandomNumber = (int) (Math.random() * imageFiles.size());
        String imageRandomFilename = imageFiles.get(imageRandomNumber);
        System.out.println(imageRandomFilename); // random

        //imageView1.setImage(new Image("Game/src/images/test_image.png"));

        File file = new File("Game/src/images/test_image.png");
        Image image = new Image(file.toURI().toString());
        imageView1.setImage(image);
    }

//    private Image loadRandomImages() {
//        int countImages = images.size();
//        int imageNumber = (int) (Math.random() * countImages);
//
//        String image = images.get(imageNumber);
//        return new Image(image);
//    }

}
