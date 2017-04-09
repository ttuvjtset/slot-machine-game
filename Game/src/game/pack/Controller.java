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

    private Game game;

    private Calculation calculation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageLoad = new LoadGenerateImages("Game/src/images/");
        game = new Game();
        calculation = new Calculation();
    }

    @FXML
    void showReels(ActionEvent event) {

        String path1 = imageLoad.randomImageFilename();
        String path2 = imageLoad.randomImageFilename();
        String path3 = imageLoad.randomImageFilename();

        image1.setImage(new Image(new File(path1).toURI().toString()));
        image2.setImage(new Image(new File(path2).toURI().toString()));
        image3.setImage(new Image(new File(path3).toURI().toString()));

        calculation.parse(path1, path2, path3);
        outputLabel1.setText(calculation.evaluate());
        outputLabel2.setText(calculation.getCurrentAmount());

    }
}
