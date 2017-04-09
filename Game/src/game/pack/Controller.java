package game.pack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Label outputLabel1;

    @FXML
    private Label outputLabel2;

    @FXML
    private Label outputLabel3;

    @FXML
    private Button generateBtn;

    @FXML
    void showReels(ActionEvent event) {
        Game game = new Game();

        outputLabel1.setText(game.generate());
        outputLabel2.setText(game.generate());
        outputLabel3.setText(game.generate());
    }

}
