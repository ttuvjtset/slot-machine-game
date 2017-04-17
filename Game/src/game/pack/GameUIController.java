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

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THREE_SET_AMOUNT = 3;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int HUNDRED_TO_GET_DIFFERENCE_PERCENTAGE = 100;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int LAYOUT_Y_SIXTY_FIVE = 65;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int WINDOW_X_TWO_HUNDRED = 200;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int WINDOW_Y_TWO_TEN = 210;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int WINDOW_W_EIGHT_HUNDRED = 800;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int WINDOW_H_SIX_HUNDRED = 600;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int PLAY_AMOUNT_CALCULATION_THREE = 3;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int PERIOD_FIFTY = 50;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THREE = 3;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int X_SIX_EIGHTY = 680;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int Y_SEVENTY_ONE = 71;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int CENTRAL_Y_POSITION_THREE_FOUR_FIVE = 345;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TOP_Y_POSITION_MINUS_TEN = -10;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int BOTTOM_Y_POSITION_SEVEN_TWENTY = 720;

    /**
     * AnchorPane.
     */
    @FXML
    private AnchorPane anchorPane;

    /**
     * Label.
     */
    @FXML
    private Label outputLabelTextStatic;

    /**
     * Label.
     */
    @FXML
    private Label outputLabelCoinsStatic;

    /**
     * Label.
     */
    @FXML
    private Label outputLabel3;

    /**
     * Button.
     */
    @FXML
    private Button generateBtn;

    /**
     * ImageView.
     */
    @FXML
    private ImageView imageView1;

    /**
     * ImageView.
     */
    @FXML
    private ImageView image1;

    /**
     * ImageView.
     */
    @FXML
    private ImageView image2;

    /**
     * ImageView.
     */
    @FXML
    private ImageView image3;

    /**
     * Button.
     */
    @FXML
    private Button resetGameBtn;

    /**
     * GridPane.
     */
    @FXML
    private GridPane gridPane;

    /**
     * Button.
     */
    @FXML
    private Button checkoutBtn;

    /**
     * Label.
     */
    @FXML
    private Label highScoreLabel;

    /**
     * Button.
     */
    @FXML
    private Button goToMenuBtn;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView2;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView3;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView4;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView5;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView6;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView7;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView8;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView9;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView10;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView11;

    /**
     * Imageview for reel animation.
     */
    @FXML
    private ImageView imageView12;

    /**
     * Output label with preloaded (we know the text before the end of animation) text.
     */
    @FXML
    private Label outputLabelTextPreloaded;

    /**
     * Ourput label with preloaded coins number (we know the text before the end of animation) .
     */
    @FXML
    private Label outputLabelCoinsPreloaded;

    /**
     * Bet one button object.
     */
    @FXML
    private ToggleButton playOneBtn;

    /**
     * Bet three button object.
     */
    @FXML
    private ToggleButton playThreeBtn;

    /**
     * Bet all button object.
     */
    @FXML
    private ToggleButton playAllBtn;

    /**
     * Stop button.
     */
    @FXML
    private Button stopBtn;

    /**
     * Win Amount Label.
     */
    @FXML
    private Label winAmountLabel;

    /**
     * High score label.
     */
    @FXML
    private Label highScoreLabel1;

    /**
     * Save name label.
     */
    @FXML
    private TextField saveNameLabel;

    /**
     * ImageView deactivated background for animation after pressing on checkout button.
     */
    @FXML
    private ImageView imageViewDeactivateBackground;

    /**
     * ImageView Blurred box for animation after pressing on checkout button.
     */
    @FXML
    private ImageView imageViewBlurredBox;

    /**
     * Label for checkout output.
     */
    @FXML
    private Label checkoutOutputLabel;

    /**
     * Label for high score details.
     */
    @FXML
    private Label highScoreDetailsLabel;

    /**
     * Button for testing purposes.
     */
    @FXML
    private Button tmpBtn;


    /**
     * ArrayList catalogue with filepathes to images.
     */
    ArrayList<String> catalogue;

    /**
     * Arraylist for normal difficulty.
     */
    ArrayList<String> catalogueNormal;

    /**
     * Arraylist for hard difficulty.
     */
    ArrayList<String> catalogueHard;

    /**
     * Draw reel object 1.
     */
    GameDrawReel drawReel1;

    /**
     * Draw reel object 2.
     */
    GameDrawReel drawReel2;

    /**
     * Draw reel object 3.
     */
    GameDrawReel drawReel3;

    /**
     * AnimateDifference for animating winning difference top right corner.
     */
    private AnimateDifference ad;

    /**
     * Calculation class object.
     */
    private Calculation calculation;

    /**
     * HighScore class object.
     */
    private HighScore highScore;

    /**
     * GameOver boolean status to restart.
     */
    private boolean gameOver = false;

    /**
     * Settings filename.
     */
    private String settingsFilename = "Game/src/settings/settings.txt";

    /**
     * Score filename.
     */
    private String scoreFilename = "Game/src/score/score.txt";

    /**
     * Coins read from the file.
     */
    private int coinsRead;

    /**
     * Difficulty read from the file.
     */
    private String difficultyRead;

    /**
     * Initialize method.
     *
     * @param location  location.
     * @param resources resources.
     */
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

        drawReel1 = new GameDrawReel(imageView, imageView2, imageView3, imageView4, 0,
                CENTRAL_Y_POSITION_THREE_FOUR_FIVE, TOP_Y_POSITION_MINUS_TEN, BOTTOM_Y_POSITION_SEVEN_TWENTY, catalogue);
        drawReel2 = new GameDrawReel(imageView5, imageView6, imageView7, imageView8, 0,
                CENTRAL_Y_POSITION_THREE_FOUR_FIVE, TOP_Y_POSITION_MINUS_TEN, BOTTOM_Y_POSITION_SEVEN_TWENTY, catalogue);
        drawReel3 = new GameDrawReel(imageView9, imageView10, imageView11, imageView12, 0,
                CENTRAL_Y_POSITION_THREE_FOUR_FIVE, TOP_Y_POSITION_MINUS_TEN, BOTTOM_Y_POSITION_SEVEN_TWENTY, catalogue);
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

    /**
     * Show reels or play / spin button.
     *
     * @param event button press.
     */
    @FXML
    void showReels(ActionEvent event) {

        if (!gameOver && calculation.playPossible()
                && (playOneBtn.isSelected() || playThreeBtn.isSelected() || playAllBtn.isSelected())) {

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
            outputLabelCoinsStatic.setText(String.valueOf(Integer.valueOf(calculation.getCurrentAmount())
                    - calculation.getPlayAmount()));
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
            //calculation.parse(drawReel1.getRandomlyGeneratedImageFilename(),
            // drawReel2.getRandomlyGeneratedImageFilename(), drawReel3.getRandomlyGeneratedImageFilename());
            //String result = calculation.evaluate();

            calculation.parse(drawReel1.getRandomlyGeneratedImageFilename(),
                    drawReel2.getRandomlyGeneratedImageFilename(), drawReel3.getRandomlyGeneratedImageFilename());
            String result = calculation.evaluate();

            outputLabelTextPreloaded.setText(result);
            outputLabelCoinsPreloaded.setText(calculation.getCurrentAmount());

            if (calculation.getWinAmount() > 0) {
                //winAmountLabel.setText("+" + String.valueOf(calculation.getWinAmount()));
                ad = new AnimateDifference(anchorPane, "+" + String.valueOf(calculation.getWinAmount()),
                        X_SIX_EIGHTY, Y_SEVENTY_ONE);

            } else {
                //winAmountLabel.setText("");
                ad = new AnimateDifference(anchorPane, "", X_SIX_EIGHTY, Y_SEVENTY_ONE);
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

                    if (drawReel1.isAnimationFinished() && drawReel2.isAnimationFinished()
                            && drawReel3.isAnimationFinished()) {
                        outputLabelTextStatic.setVisible(false);
                        outputLabelCoinsStatic.setVisible(false);
                        outputLabelTextPreloaded.setVisible(true);
                        outputLabelCoinsPreloaded.setVisible(true);

                        resetGameBtn.setDisable(false);
                        ad.playAnimation();

                        if (Integer.valueOf(calculation.getCurrentAmount()) < THREE) {
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
            }, 0, PERIOD_FIFTY, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Button bet one.
     *
     * @param event button press.
     */
    @FXML
    void PlayOne(ActionEvent event) {
        calculation.setPlayAmount(1);
    }

    /**
     * Button play three.
     *
     * @param event button press.
     */
    @FXML
    void PlayThree(ActionEvent event) {
        calculation.setPlayAmount(PLAY_AMOUNT_CALCULATION_THREE);
    }

    /**
     * Button play all.
     *
     * @param event button press.
     */
    @FXML
    void playAll(ActionEvent event) {
        calculation.setPlayAmount(Integer.valueOf(calculation.getCurrentAmount()));
    }

    /**
     * Checkout button to view the analysis, if you won, lost, or you play was no win/no lost.
     * The box is animated.
     *
     * @param event button press.
     */
    @FXML
    void checkoutAndSave(ActionEvent event) {

        goToMenuBtn.setVisible(false);
        if (ad != null) ad.deleteAnimateDifferenceLabel();

        DrawTransparentBox dtb = new DrawTransparentBox(anchorPane, imageViewDeactivateBackground,
                imageViewBlurredBox, goToMenuBtn, LAYOUT_Y_SIXTY_FIVE, WINDOW_X_TWO_HUNDRED,
                WINDOW_Y_TWO_TEN, WINDOW_W_EIGHT_HUNDRED, WINDOW_H_SIX_HUNDRED, 0.6);
        FadeTransition ft0 = dtb.generateFadeTransition();
        ft0.play();

        ft0.setOnFinished(e -> {

            goToMenuBtn.setVisible(true);
            checkoutOutputLabel.setVisible(true);
            int wonAmount = Integer.valueOf(calculation.getCurrentAmount()) - coinsRead;
            System.out.println("Started: " + coinsRead + " Checking out: " + calculation.getCurrentAmount()
                    + " Won: " + wonAmount);

            String wonOrLostText = "";
            int scoreCalculatedInt = -1;
            if (wonAmount > 0) {
                float wonAmountFloat = (float) wonAmount;
                float coinsReadFloat = (float) coinsRead;
                float scoreCalculated = (wonAmountFloat / coinsReadFloat) * HUNDRED_TO_GET_DIFFERENCE_PERCENTAGE;
                scoreCalculatedInt = (int) scoreCalculated;
                System.out.println(wonAmount + " / " + coinsRead + " = " + scoreCalculatedInt);
                wonOrLostText = "You won " + wonAmount + " coins! \nYour score is " + scoreCalculatedInt + ".";
            } else if (wonAmount < 0) {
                wonOrLostText = "You lost " + String.valueOf(Math.abs(wonAmount)) + " coins.";
            } else if (wonAmount == 0) {
                wonOrLostText = "You did not lose or win anything!";
            }

            highScoreDetailsLabel.setText("You've started with " + coinsRead + " coins.\nNow checking out with "
                    + calculation.getCurrentAmount() + " coins.\n\n" + wonOrLostText);
            highScoreDetailsLabel.setVisible(true);

            if (scoreCalculatedInt > 0) {
                highScoreLabel.setVisible(true);
                String highScoreSaveProcessAnswer = highScore.save(String.valueOf(scoreCalculatedInt));
                highScoreLabel.setText(highScoreSaveProcessAnswer);
            }
        });
    }

    /**
     * Reset the game button. Available after the amount of coins is zero.
     *
     * @param event button press.
     */
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
            calculation.setPlayAmount(THREE_SET_AMOUNT);
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

    /**
     * Stop button for skipping the animation if the minimum amount is played.
     *
     * @param event button press.
     */
    @FXML
    void skipAnimation(ActionEvent event) {
        if (drawReel1.skippibleAnimation() && drawReel2.skippibleAnimation() && drawReel3.skippibleAnimation()) {
            drawReel1.skipAnimation();
            drawReel2.skipAnimation();
            drawReel3.skipAnimation();
            stopBtn.setDisable(true);
        }
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
     * Button for testing purposes, invisible on the main stage.
     *
     * @param event button press.
     */
    @FXML
    void tmpTestAnim(ActionEvent event) {

    }
}
