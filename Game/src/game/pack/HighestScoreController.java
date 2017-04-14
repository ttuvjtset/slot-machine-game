package game.pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HighestScoreController implements Initializable {

    @FXML
    private Button GoToMenuBtn;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button resetBtn;

    @FXML
    private Label status;

    private String scoreFilename = "Game/src/score/score.txt";

    private LoadSaveScore lss;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        status.setText("");
        lss = new LoadSaveScore(scoreFilename);
        lss.checkAndLoadSettings();
        scoreLabel.setText(String.valueOf(lss.getScoreRead()));
        status.setText("Score data loaded");
        if (lss.isDataRestored()) status.setText("Data corrupted. Score data restored");
    }

    @FXML
    void GoToMenu(ActionEvent event) throws Exception {
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
