package game.pack;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button goToMenuBtn;

    @FXML
    private TextField coinsInput;

    @FXML
    private ToggleButton normalDifficultyBtn;

    @FXML
    private ToggleButton hardDifficultyBtn;

    @FXML
    private ToggleGroup difficultyBtns;

    @FXML
    private Label statusLabel;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private ImageView imageViewDeactivateBackground;

    @FXML
    private ImageView imageViewBlurredBox;

    @FXML
    private Button resetBtn;

    @FXML
    private Rectangle tmpBox;


    private boolean dataCorrupted = false;

    private int coinsRead;

    private String difficultyRead;

    private String settingsFilename = "Game/src/settings/settings.txt";

    private LoadRestoreSettings lrs;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tmpBox.setVisible(false);
        coinsInput.setVisible(false);
        normalDifficultyBtn.setVisible(false);
        hardDifficultyBtn.setVisible(false);
        statusLabel.setVisible(false);
        resetBtn.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        goToMenuBtn.setVisible(false);

        lrs = new LoadRestoreSettings(settingsFilename);
        displayData();
        if (lrs.isDataRestored()) statusLabel.setText("Setting file corrupted. Settings were restored.");

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, null, 0, 200,300, 800,535, 0.80);
        FadeTransition ft0 = dtb.generateFadeTransition();
        ft0.play();

        ft0.setOnFinished(e -> {
            coinsInput.setVisible(true);
            normalDifficultyBtn.setVisible(true);
            hardDifficultyBtn.setVisible(true);
            statusLabel.setVisible(true);
            resetBtn.setVisible(true);
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            goToMenuBtn.setVisible(true);
        });

    }


    @FXML
    public void goToMenu(ActionEvent event) throws Exception {
        Parent blah = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }


    @FXML
    public void hardDifficulty(ActionEvent event) {
        writeToFile();
    }

    @FXML
    public void normalDifficulty(ActionEvent event) {
        writeToFile();
    }

    @FXML
    public void writeOnKeyReleased(KeyEvent event) {
        writeToFile();
    }

    public void writeToFile() {
        try{
            if (hardDifficultyBtn.isSelected() || normalDifficultyBtn.isSelected()) {
                int coinsEntered = Integer.valueOf(coinsInput.getText());
                if (coinsEntered > 0 && coinsEntered <= 100){
                    System.out.println("Digit!");

                    FileWrite fw = new FileWrite(settingsFilename);

                    String difficultyToWrite = "";
                    if (hardDifficultyBtn.isSelected()) {
                        difficultyToWrite = ";hard";
                    } else if (normalDifficultyBtn.isSelected()) {
                        difficultyToWrite = ";normal";
                    }
                    fw.writeData(coinsInput.getText() + difficultyToWrite);
                    System.out.println("written!");
                    statusLabel.setText("Autosaved");
                    fw.close();
                } else {
                    statusLabel.setText("Coins only from 1 to 100 accepted");
                    System.out.println("Entered not digit from 1 to 100!");
                }
            } else {
                System.out.println("Select difficulty");
                statusLabel.setText("Select difficulty");
            }

        } catch (NumberFormatException e) {
            statusLabel.setText("Not an integer!");
            System.out.println("Not an integer!");
            //e.printStackTrace();
        }
    }

    @FXML
    public void reset(ActionEvent event) {
        lrs.rewriteWithDefaults();
        lrs.checkAndLoadSettings();
        displayData();
        statusLabel.setText("Data restored");
    }

    public void displayData(){
        this.coinsRead = lrs.getCoinsRead();
        this.difficultyRead = lrs.getDifficultyRead();
        coinsInput.setText(String.valueOf(this.coinsRead));
        if (this.difficultyRead.equals("normal")) {
            normalDifficultyBtn.setSelected(true);
            hardDifficultyBtn.setSelected(false);
            statusLabel.setText("Data loaded");
        } else if (this.difficultyRead.equals("hard")) {
            normalDifficultyBtn.setSelected(false);
            hardDifficultyBtn.setSelected(true);
            statusLabel.setText("Data loaded");
        } else {
            statusLabel.setText("Difficulty not recognized");
        }

    }


}
