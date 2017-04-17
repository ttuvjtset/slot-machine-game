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

/**
 * Main Menu Controller.
 */
public class MainMenuController {
    /**
     * NewGameBtn.
     */
    @FXML
    private Button NewGameBtn;

    /**
     * HighestScoreBtn.
     */
    @FXML
    private Button HighestScoreBtn;

    /**
     * RulesBtn.
     */
    @FXML
    private Button RulesBtn;

    /**
     * SettingsBtn.
     */
    @FXML
    private Button SettingsBtn;

    /**
     * ExitBtn.
     */
    @FXML
    private Button ExitBtn;

    /**
     * New game.
     *
     * @param event button press.
     * @throws IOException IOException.
     */
    @FXML
    void GoToNewGame(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GameUI.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    /**
     * Highest score.
     *
     * @param event button press.
     * @throws IOException IOException.
     */
    @FXML
    void GoToHighestScore(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HighestScore.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    /**
     * Rules.
     *
     * @param event button press.
     * @throws IOException IOException.
     */
    @FXML
    void GoToRules(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    /**
     * Settings.
     *
     * @param event button press.
     * @throws IOException IOException.
     */
    @FXML
    void GoToSettings(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    /**
     * Exit.
     *
     * @param event button press.
     */
    @FXML
    void Exit(ActionEvent event) {
        Stage stage = (Stage) ExitBtn.getScene().getWindow();
        stage.close();
    }
}

