package game.pack;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RulesController  implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Rectangle tmpBox;

    @FXML
    private Button goToMenuBtn;

    @FXML
    private ImageView imageViewDeactivateBackground;

    @FXML
    private ImageView imageViewBlurredBox;

    @FXML
    private Label label2;

    @FXML
    private Label label1;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    public void initialize(URL location, ResourceBundle resources) {
        tmpBox.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        goToMenuBtn.setVisible(false);

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, null, 0, 200,300, 800,610, 0.80);
        FadeTransition ft0 = dtb.generateFadeTransition();
        ft0.play();

        ft0.setOnFinished(e -> {
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            goToMenuBtn.setVisible(true);

        });

    }

    @FXML
    void goToMenu(ActionEvent event) throws Exception{
        Parent blah = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

}
