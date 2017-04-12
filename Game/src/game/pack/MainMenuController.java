package game.pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button NewGameBtn;

    @FXML
    private Button HighestScoreBtn;

    @FXML
    private Button RulesBtn;

    @FXML
    private Button SettingsBtn;

    @FXML
    private Button ExitBtn;



    @FXML
    void GoToNewGame(ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("GameUI.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    void GoToHighestScore(ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("HighestScore.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    void GoToRules(ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    void GoToSettings(ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    void Exit(ActionEvent event) {
        Stage stage = (Stage) ExitBtn.getScene().getWindow();
        stage.close();
    }
}

