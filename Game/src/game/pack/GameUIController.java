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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameUIController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label outputLabelTextStatic;

    @FXML
    private Label outputLabelCoinsStatic;

    @FXML
    private Label outputLabel3;

    @FXML
    private Button generateBtn;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private Button resetGameBtn;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button checkoutBtn;

    @FXML
    private Label highScoreLabel;

    @FXML
    private Button goToMenuBtn;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageView5;

    @FXML
    private ImageView imageView6;

    @FXML
    private ImageView imageView7;

    @FXML
    private ImageView imageView8;

    @FXML
    private ImageView imageView9;

    @FXML
    private ImageView imageView10;

    @FXML
    private ImageView imageView11;

    @FXML
    private ImageView imageView12;

    @FXML
    private Label outputLabelTextPreloaded;

    @FXML
    private Label outputLabelCoinsPreloaded;

    @FXML
    private ToggleButton playOneBtn;

    @FXML
    private ToggleButton playThreeBtn;

    @FXML
    private ToggleButton playAllBtn;

    @FXML
    private Button stopBtn;

    @FXML
    private Label winAmountLabel;

    @FXML
    private Label highScoreLabel1;

    @FXML
    private TextField saveNameLabel;

    @FXML
    private ImageView imageViewDeactivateBackground;

    @FXML
    private ImageView imageViewBlurredBox;

    @FXML
    private Label checkoutOutputLabel;

    @FXML
    private Label highScoreDetailsLabel;

    @FXML
    private Button tmpBtn;


    ArrayList<String> catalogue;

    ArrayList<String> catalogueNormal;

    ArrayList<String> catalogueHard;

    GameDrawReel drawReel1;

    GameDrawReel drawReel2;

    GameDrawReel drawReel3;



    private AnimateDifference ad;

    private Calculation calculation;

    private HighScore highScore;

    private boolean gameOver = false;

    //private LoadGenerateImages imageLoad;

    private String settingsFilename = "Game/src/settings/settings.txt";

    private String scoreFilename = "Game/src/score/score.txt";

    private int coinsRead;

    private String difficultyRead;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LoadRestoreSettings lrs = new LoadRestoreSettings(settingsFilename);
        coinsRead = lrs.getCoinsRead();
        difficultyRead = lrs.getDifficultyRead();

        calculation = new Calculation(coinsRead);

        highScore = new HighScore(scoreFilename);

        checkoutBtn.setDisable(true);
        resetGameBtn.setDisable(true);
        stopBtn.setVisible(false);
        tmpBtn.setVisible(false);

        highScoreLabel.setVisible(false);
        highScoreLabel1.setVisible(false);
        saveNameLabel.setVisible(false);
        checkoutOutputLabel.setVisible(false);
        highScoreDetailsLabel.setVisible(false);

        catalogueNormal = new ArrayList<>();
        catalogueNormal.add("Game\\src\\images\\Apple.png");
        catalogueNormal.add("Game\\src\\images\\Banana.png");
        catalogueNormal.add("Game\\src\\images\\Lemon.png");
        catalogueNormal.add("Game\\src\\images\\Melon.png");
        catalogueNormal.add("Game\\src\\images\\Orange.png");
        catalogueNormal.add("Game\\src\\images\\Grape.png");
        catalogueNormal.add("Game\\src\\images\\Cherry.png");

        catalogueHard = new ArrayList<>();
        catalogueHard.addAll(catalogueNormal);
        catalogueHard.addAll(catalogueNormal);

        catalogueNormal.add("Game\\src\\images\\Joker.png");
        catalogueNormal.add("Game\\src\\images\\Joker.png");
        catalogueHard.add("Game\\src\\images\\Joker.png");

        if (difficultyRead.equals("normal")) {
            catalogue = catalogueNormal;
        } else if (difficultyRead.equals("hard")) {
            catalogue = catalogueHard;
        }

        //////////// inactive //////////

        //catalogueNormal.add("Game\\src\\images\\Crystal.png");

        //////////// inactive //////////

        drawReel1 = new GameDrawReel(imageView, imageView2, imageView3, imageView4, 0, 345, -10, 720, catalogue);
        drawReel2 = new GameDrawReel(imageView5, imageView6, imageView7, imageView8, 0, 345, -10, 720, catalogue);
        drawReel3 = new GameDrawReel(imageView9, imageView10, imageView11, imageView12, 0, 345, -10, 720, catalogue);
        drawReel1.initialize();
        drawReel2.initialize();
        drawReel3.initialize();

        outputLabelTextStatic.setText("");
        outputLabelTextPreloaded.setText("");
        outputLabelTextPreloaded.setVisible(false);

        outputLabelCoinsStatic.setText(calculation.getCurrentAmount());
        outputLabelCoinsPreloaded.setVisible(false);

        winAmountLabel.setText("");
    }

    @FXML
    void showReels(ActionEvent event) {

        if (!gameOver && calculation.playPossible() && (playOneBtn.isSelected() || playThreeBtn.isSelected() || playAllBtn.isSelected())) {

            if (playAllBtn.isSelected()) calculation.setPlayAmount(Integer.valueOf(calculation.getCurrentAmount()));

            highScoreLabel.setVisible(false);
            highScoreLabel1.setVisible(false);
            saveNameLabel.setVisible(false);

            generateBtn.setVisible(false);
            resetGameBtn.setDisable(true);
            stopBtn.setDisable(false);
            stopBtn.setVisible(true);
            checkoutBtn.setDisable(true);

            winAmountLabel.setVisible(false);

            outputLabelTextStatic.setVisible(false);
            outputLabelTextPreloaded.setVisible(false);

            outputLabelCoinsStatic.setVisible(true);
            outputLabelCoinsStatic.setText(String.valueOf(Integer.valueOf(calculation.getCurrentAmount()) - calculation.getPlayAmount()));
            outputLabelCoinsPreloaded.setVisible(false);

            drawReel1.generateAndPlay();
            drawReel2.generateAndPlay();
            drawReel3.generateAndPlay();

            if (ad != null) ad.stopAnimation();

            // static images
            //String path1 = imageLoad.randomImageFilename();
            //String path2 = imageLoad.randomImageFilename();
            //String path3 = imageLoad.randomImageFilename();
            //
            //image1.setImage(new Image(new File(path1).toURI().toString()));
            //image2.setImage(new Image(new File(path2).toURI().toString()));
            //image3.setImage(new Image(new File(path3).toURI().toString()));
            //
            //calculation.parse(drawReel1.getRandomlyGeneratedImageFilename(), drawReel2.getRandomlyGeneratedImageFilename(), drawReel3.getRandomlyGeneratedImageFilename());
            //String result = calculation.evaluate();

            calculation.parse(drawReel1.getRandomlyGeneratedImageFilename(), drawReel2.getRandomlyGeneratedImageFilename(), drawReel3.getRandomlyGeneratedImageFilename());
            String result = calculation.evaluate();

            outputLabelTextPreloaded.setText(result);
            outputLabelCoinsPreloaded.setText(calculation.getCurrentAmount());

            if (calculation.getWinAmount() > 0) {
                //winAmountLabel.setText("+" + String.valueOf(calculation.getWinAmount()));
                ad = new AnimateDifference(anchorPane, "+" + String.valueOf(calculation.getWinAmount()), 680, 71);

            } else {
                //winAmountLabel.setText("");
                ad = new AnimateDifference(anchorPane, "", 680, 71);
            }

            //////// temp ///////////
            //drawReel1.skipAnimation();
            //drawReel2.skipAnimation();
            //drawReel3.skipAnimation();
            //////// temp ///////////

            ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
            ses.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    if (drawReel1.isAnimationFinished() && drawReel2.isAnimationFinished() && drawReel3.isAnimationFinished()) {
                        outputLabelTextStatic.setVisible(false);
                        outputLabelCoinsStatic.setVisible(false);
                        outputLabelTextPreloaded.setVisible(true);
                        outputLabelCoinsPreloaded.setVisible(true);

                        resetGameBtn.setDisable(false);
                        ad.playAnimation();

                        if (Integer.valueOf(calculation.getCurrentAmount()) < 3) {
                            playThreeBtn.setDisable(true);
                            playOneBtn.setSelected(true);
                            calculation.setPlayAmount(1);
                        } else {
                            playThreeBtn.setDisable(false);
                        }

                        if (result.equals("No coins left!")) {
                            System.out.println("debugg, game over!");
                            gameOver = true;
                            generateBtn.setVisible(false);
                            checkoutBtn.setDisable(true);
                            stopBtn.setVisible(false);
                            playOneBtn.setDisable(true);
                            playThreeBtn.setDisable(true);
                            playAllBtn.setDisable(true);
                        } else {
                            generateBtn.setVisible(true);
                            stopBtn.setVisible(false);
                            checkoutBtn.setDisable(false);
                        }
                        System.out.println("All finished!!!!");

                        ses.shutdown();
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }


    @FXML
    void PlayOne(ActionEvent event) {
        calculation.setPlayAmount(1);
    }

    @FXML
    void PlayThree(ActionEvent event) {
        calculation.setPlayAmount(3);
    }

    @FXML
    void playAll(ActionEvent event) {
        calculation.setPlayAmount(Integer.valueOf(calculation.getCurrentAmount()));
    }


    @FXML
    void checkoutAndSave(ActionEvent event) {

        goToMenuBtn.setVisible(false);
        if (ad != null) ad.deleteAnimateDifferenceLabel();

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground, imageViewBlurredBox, goToMenuBtn, 65, 200, 210, 800, 600, 0.6);
        FadeTransition ft0 = dtb.generateFadeTransition();
        ft0.play();

        ft0.setOnFinished(e -> {

            goToMenuBtn.setVisible(true);
            checkoutOutputLabel.setVisible(true);
            int wonAmount = Integer.valueOf(calculation.getCurrentAmount()) - coinsRead;
            System.out.println("Started: " + coinsRead + " Checking out: " + calculation.getCurrentAmount() + " Won: " + wonAmount);

            String wonOrLostText = "";
            int scoreCalculatedInt = -1;
            if (wonAmount > 0) {
                float wonAmountFloat = (float) wonAmount;
                float coinsReadFloat = (float) coinsRead;
                float scoreCalculated = (wonAmountFloat / coinsReadFloat) * 100;
                scoreCalculatedInt = (int) scoreCalculated;
                System.out.println(wonAmount + " / " + coinsRead + " = " + scoreCalculatedInt);
                wonOrLostText = "You won " + wonAmount + " coins! \nYour score is " + scoreCalculatedInt + ".";
            } else if (wonAmount < 0) {
                wonOrLostText = "You lost " + String.valueOf(Math.abs(wonAmount)) + " coins.";
            } else if (wonAmount == 0) {
                wonOrLostText = "You did not lose or win anything!";
            }

            highScoreDetailsLabel.setText("You've started with " + coinsRead + " coins.\nNow checking out with " + calculation.getCurrentAmount() + " coins.\n\n" + wonOrLostText);
            highScoreDetailsLabel.setVisible(true);

            if (scoreCalculatedInt > 0) {
                highScoreLabel.setVisible(true);
                String highScoreSaveProcessAnswer = highScore.save(String.valueOf(scoreCalculatedInt));
                highScoreLabel.setText(highScoreSaveProcessAnswer);
            }
        });
    }


    @FXML
    void resetGame(ActionEvent event) {
        if (ad != null) ad.deleteAnimateDifferenceLabel();

        resetGameBtn.setDisable(true);
        winAmountLabel.setVisible(false);
        generateBtn.setVisible(true);

        calculation = new Calculation(coinsRead);
        gameOver = false;

        playOneBtn.setDisable(false);
        playThreeBtn.setDisable(false);
        playAllBtn.setDisable(false);

        if (playThreeBtn.isSelected()) {
            calculation.setPlayAmount(3);
            playThreeBtn.setDisable(false);
        } else {
            playOneBtn.setSelected(true);
            calculation.setPlayAmount(1);
        }

        if (playAllBtn.isSelected()) {
            playOneBtn.setSelected(true);
            calculation.setPlayAmount(1);
        }

        outputLabelTextStatic.setVisible(true);
        outputLabelTextStatic.setText("");
        outputLabelTextPreloaded.setText("");
        outputLabelTextPreloaded.setVisible(false);

        outputLabelCoinsPreloaded.setVisible(false);
        outputLabelCoinsStatic.setVisible(true);
        outputLabelCoinsStatic.setText(calculation.getCurrentAmount());

    }

    @FXML
    void skipAnimation(ActionEvent event) {
        if (drawReel1.skippibleAnimation() && drawReel2.skippibleAnimation() && drawReel3.skippibleAnimation()) {
            drawReel1.skipAnimation();
            drawReel2.skipAnimation();
            drawReel3.skipAnimation();
            stopBtn.setDisable(true);
        }
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
    void tmpTestAnim(ActionEvent event) {

    }
}
