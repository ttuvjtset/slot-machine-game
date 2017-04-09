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

    private LoadGenerateImages imageLoad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageLoad = new LoadGenerateImages("Game/src/images/");
        //imageLoad.loadImages();
    }

    @FXML
    void showReels(ActionEvent event) {
        Game game = new Game();

        outputLabel1.setText(game.generate());
        outputLabel2.setText(game.generate());
        outputLabel3.setText(game.generate());

        image1.setImage(new Image(new File(imageLoad.randomImageFilename()).toURI().toString()));
        image2.setImage(new Image(new File(imageLoad.randomImageFilename()).toURI().toString()));
        image3.setImage(new Image(new File(imageLoad.randomImageFilename()).toURI().toString()));

    }



}
