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

public class HighestScoreController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Rectangle tmpBox;

    @FXML
    private ImageView imageViewDeactivateBackground;

    @FXML
    private ImageView imageViewBlurredBox;

    @FXML
    private Button goToMenuBtn;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button resetBtn;

    @FXML
    private Label status;


    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    private String scoreFilename = "Game/src/score/score.txt";

    private LoadSaveScore lss;

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

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, null, 0, 221,300, 759,427, 0.80);
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

    @FXML
    void goToMenu(ActionEvent event) throws Exception {
        Parent blah = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }


    @FXML
    void reset(ActionEvent event) {
        lss.rewriteWithDefaults();
        lss.readScoreFile();
        scoreLabel.setText(String.valueOf(lss.getScoreRead()));
        status.setText("Score file is restored");
    }
}
