package game.pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HighestScoreController {

    @FXML
    private Button GoToMenuBtn;

    @FXML
    void GoToMenu(ActionEvent event) throws Exception {
        Parent blah = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

}
