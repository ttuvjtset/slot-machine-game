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

/**
 * HighestScoreController.
 */
public class HighestScoreController implements Initializable {

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_TWO_ONE = 221;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THREE_HUNDRED = 300;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int SEVEN_FIVE_NINE = 759;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int FOUR_TWO_SEVEN = 427;

    /**
     * Anchorpane.
     */
    @FXML
    private AnchorPane anchorPane;

    /**
     * Rectangular for testing purposes.
     */
    @FXML
    private Rectangle tmpBox;

    /**
     * imageView imageViewDeactivateBackground.
     */
    @FXML
    private ImageView imageViewDeactivateBackground;

    /**
     * ImageView imageViewBlurredBox.
     */
    @FXML
    private ImageView imageViewBlurredBox;

    /**
     * Go to menu button.
     */
    @FXML
    private Button goToMenuBtn;

    /**
     * Score label.
     */
    @FXML
    private Label scoreLabel;

    /**
     * Reset button.
     */
    @FXML
    private Button resetBtn;

    /**
     * Status.
     */
    @FXML
    private Label status;

    /**
     * Just text label for animation purpose.
     */
    @FXML
    private Label label1;

    /**
     * Just text label for animation purpose.
     */
    @FXML
    private Label label2;

    /**
     * Just text label for animation purpose.
     */
    @FXML
    private Label label3;

    /**
     * Score filename.
     */
    private String scoreFilename = "Game/src/score/score.txt";

    /**
     * LoadSaveScore.
     */
    private LoadSaveScore lss;

    /**
     * Initialize method.
     *
     * @param location  location.
     * @param resources resources.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tmpBox.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        scoreLabel.setVisible(false);
        status.setVisible(false);
        resetBtn.setVisible(false);
        goToMenuBtn.setVisible(false);

        status.setText("");
        lss = new LoadSaveScore(scoreFilename);
        lss.checkAndLoadSettings();
        scoreLabel.setText(String.valueOf(lss.getScoreRead()));
        status.setText("Score data loaded");
        if (lss.isDataRestored()) status.setText("Data corrupted. Score data restored");

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, null, 0, TWO_TWO_ONE, THREE_HUNDRED, SEVEN_FIVE_NINE, FOUR_TWO_SEVEN, 0.80);
        FadeTransition ft0 = dtb.generateFadeTransition();
        ft0.play();

        ft0.setOnFinished(e -> {
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            scoreLabel.setVisible(true);
            status.setVisible(true);
            resetBtn.setVisible(true);
            goToMenuBtn.setVisible(true);

        });
    }

    /**
     * Go to menu button.
     *
     * @param event button press.
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

    /**
     * Reset button.
     *
     * @param event button press.
     */
    @FXML
    void reset(ActionEvent event) {
        lss.rewriteWithDefaults();
        lss.readScoreFile();
        scoreLabel.setText(String.valueOf(lss.getScoreRead()));
        status.setText("Score file is restored");
    }
}
