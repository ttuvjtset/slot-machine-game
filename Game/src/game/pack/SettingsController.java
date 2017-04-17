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

    /**
     * MAGIC NUMBER FOR MASKING.
     */
    public static final int TWO_HUNDRED = 200;

    /**
     * MAGIC NUMBER FOR MASKING.
     */
    public static final int THREE_HUNDRED = 300;

    /**
     * MAGIC NUMBER FOR MASKING.
     */
    public static final int EIGHT_HUNDRED = 800;

    /**
     * MAGIC NUMBER FOR MASKING.
     */
    public static final int FIVE_HUNDRED_THERTY_FIVE = 535;

    /**
     * Anchorpane.
     */
    @FXML
    private AnchorPane anchorPane;

    /**
     * Gotomenu button.
     */
    @FXML
    private Button goToMenuBtn;

    /**
     * Textinput coinsInput.
     */
    @FXML
    private TextField coinsInput;

    /**
     * Toggle normal difficulty button.
     */
    @FXML
    private ToggleButton normalDifficultyBtn;

    /**
     * Toggle hard difficulty button.
     */
    @FXML
    private ToggleButton hardDifficultyBtn;

    /**
     * Difficulty Buttons.
     */
    @FXML
    private ToggleGroup difficultyBtns;

    /**
     * Status label.
     */
    @FXML
    private Label statusLabel;

    /**
     * Just text labels.
     */
    @FXML
    private Label label1;

    /**
     * Just text labels.
     */
    @FXML
    private Label label2;

    /**
     * Just text labels.
     */
    @FXML
    private Label label3;

    /**
     * Just text labels.
     */
    @FXML
    private Label label4;

    /**
     * Just text labels.
     */
    @FXML
    private Label label5;

    /**
     * ImageView DeactivateBackground.
     */
    @FXML
    private ImageView imageViewDeactivateBackground;

    /**
     * ImageView BlurredBox.
     */
    @FXML
    private ImageView imageViewBlurredBox;

    /**
     * Reset Button.
     */
    @FXML
    private Button resetBtn;

    /**
     * Rectangular for testing purposes.
     */
    @FXML
    private Rectangle tmpBox;

    /**
     * Boolean status for data corruption.
     */
    private boolean dataCorrupted = false;

    /**
     * Coins read from the file.
     */
    private int coinsRead;

    /**
     * Difficulty read from the file.
     */
    private String difficultyRead;

    /**
     * String path.
     */
    private String settingsFilename = "Game/src/settings/settings.txt";

    /**
     * LoadRestoreSettings object.
     */
    private LoadRestoreSettings lrs;

    /**
     * Initialize method.
     *
     * @param location  location.
     * @param resources resources.
     */
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

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, null, 0, TWO_HUNDRED, THREE_HUNDRED, EIGHT_HUNDRED, FIVE_HUNDRED_THERTY_FIVE, 0.80);
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

    /**
     * GoToMenu Button.
     *
     * @param event event.
     * @throws Exception Exception.
     */
    @FXML
    public void goToMenu(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    /**
     * Pressed hard difficulty button.
     *
     * @param event button pressed.
     */
    @FXML
    public void hardDifficulty(ActionEvent event) {
        writeToFile();
    }

    /**
     * Pressed normal difficulty button.
     *
     * @param event button pressed.
     */
    @FXML
    public void normalDifficulty(ActionEvent event) {
        writeToFile();
    }

    /**
     * Write on key - autosave.
     *
     * @param event event.
     */
    @FXML
    public void writeOnKeyReleased(KeyEvent event) {
        writeToFile();
    }

    /**
     * Write to file.
     */
    public void writeToFile() {
        try {
            if (hardDifficultyBtn.isSelected() || normalDifficultyBtn.isSelected()) {
                int coinsEntered = Integer.valueOf(coinsInput.getText());
                if (coinsEntered > 0 && coinsEntered <= 100) {
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

    /**
     * Restore data.
     *
     * @param event event.
     */
    @FXML
    public void reset(ActionEvent event) {
        lrs.rewriteWithDefaults();
        lrs.checkAndLoadSettings();
        displayData();
        statusLabel.setText("Data restored");
    }

    /**
     * Display data.
     */
    public void displayData() {
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
