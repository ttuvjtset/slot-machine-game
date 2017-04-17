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

public class RulesController implements Initializable {

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_HUNDERT = 200;


    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THREE_HUNDERT = 300;


    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int EIGHT_HUNDRED = 800;


    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int SIX_HUNDRED_TEN = 610;

    /**
     * AnchorPane.
     */
    @FXML
    private AnchorPane anchorPane;

    /**
     * Box for testing purposes.
     */
    @FXML
    private Rectangle tmpBox;

    /**
     * Button.
     */
    @FXML
    private Button goToMenuBtn;

    /**
     * imageViewDeactivateBackground
     */
    @FXML
    private ImageView imageViewDeactivateBackground;

    /**
     * imageViewBlurredBox
     */
    @FXML
    private ImageView imageViewBlurredBox;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label2;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label1;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label3;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label4;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label5;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label6;

    /**
     * Just text label for animation.
     */
    @FXML
    private Label label7;

    /**
     * Initialize method.
     *
     * @param location  location.
     * @param resources resources.
     */
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

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, null, 0, TWO_HUNDERT, THREE_HUNDERT, EIGHT_HUNDRED, SIX_HUNDRED_TEN, 0.80);
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

    /**
     * Button gotoMenu.
     *
     * @param event event.
     * @throws Exception Exception.
     */
    @FXML
    void goToMenu(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

}
