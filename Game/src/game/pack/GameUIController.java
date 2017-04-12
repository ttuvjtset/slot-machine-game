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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameUIController implements Initializable {

    @FXML
    private Label outputLabel1;

    @FXML
    private Label outputLabel2;

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
    private TextField coinsInput;

    @FXML
    private Button setCoinsBtn;

    @FXML
    private Button newGame;

    @FXML
    private Button quitBtn;

    @FXML
    private Label highScoreLabel;

    private LoadGenerateImages imageLoad;

    //private Game game;

    @FXML
    private Button goToMenuBtn;

    private Calculation calculation;

    private HighScore highScore;

    private boolean gameOver = false;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageView9;

    @FXML
    private ImageView imageView10;

    @FXML
    private ImageView imageView11;

    @FXML
    private ImageView imageView12;

    @FXML
    private ImageView imageView5;

    @FXML
    private ImageView imageView6;

    @FXML
    private ImageView imageView7;

    @FXML
    private ImageView imageView8;


    ArrayList<String> catalogue;

    GameDrawReel drawReel1;

    GameDrawReel drawReel2;

    GameDrawReel drawReel3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageLoad = new LoadGenerateImages("Game/src/images/");

        calculation = new Calculation();
        highScore = new HighScore();
        quitBtn.setVisible(false);
        newGame.setVisible(false);


        catalogue = new ArrayList<>();
        catalogue.add("Game\\src\\images\\Apple.png");
        catalogue.add("Game\\src\\images\\Banana.png");
        catalogue.add("Game\\src\\images\\Lemon.png");
        //catalogue.add("Game\\src\\images\\Cherry.png");
        //catalogue.add("Game\\src\\images\\Crystal.png");
        //catalogue.add("Game\\src\\images\\Grape.png");
        catalogue.add("Game\\src\\images\\Joker.png");
        catalogue.add("Game\\src\\images\\Melon.png");
        catalogue.add("Game\\src\\images\\Orange.png");

        drawReel1 = new GameDrawReel(imageView, imageView2, imageView3, imageView4, 93, 324, -14, 700, catalogue);
        drawReel2 = new GameDrawReel(imageView5, imageView6, imageView7, imageView8, 0, 324, -14, 700, catalogue);
        drawReel3 = new GameDrawReel(imageView9, imageView10, imageView11, imageView12, 0, 324, -14, 700, catalogue);
        drawReel1.initialize();
        drawReel2.initialize();
        drawReel3.initialize();

    }

    @FXML
    void showReels(ActionEvent event) {

        if (!gameOver) {
            quitBtn.setVisible(true);

            drawReel1.generateAndPlay();
            drawReel2.generateAndPlay();
            drawReel3.generateAndPlay();


            // static images
            //String path1 = imageLoad.randomImageFilename();
            //String path2 = imageLoad.randomImageFilename();
            //String path3 = imageLoad.randomImageFilename();
            //System.out.println("path1" + path1);
            // static images
            //image1.setImage(new Image(new File(path1).toURI().toString()));
            //image2.setImage(new Image(new File(path2).toURI().toString()));
            //image3.setImage(new Image(new File(path3).toURI().toString()));

            //calculation.parse(drawReel1.getRandomlyGeneratedImageFilename(), drawReel2.getRandomlyGeneratedImageFilename(), drawReel3.getRandomlyGeneratedImageFilename());
            //String result = calculation.evaluate();

            //evaluation();
            calculation.parse(drawReel1.getRandomlyGeneratedImageFilename(), drawReel2.getRandomlyGeneratedImageFilename(), drawReel3.getRandomlyGeneratedImageFilename());
            String result = calculation.evaluate();

            if (result.equals("Game over!")) {
                gameOver = true;
                newGame.setVisible(true);
                generateBtn.setVisible(false);
                quitBtn.setVisible(false);
            }

            outputLabel1.setText(result);
            outputLabel2.setText(calculation.getCurrentAmount());

            ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

            ses.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    if (drawReel1.isAnimationFinished() && drawReel2.isAnimationFinished() && drawReel3.isAnimationFinished()) {
                        System.out.println("All finished!!!!");
                        outputLabel1.setVisible(false);
                        outputLabel2.setVisible(false);
                        ses.shutdown();
                    }
                }
            }, 0, 100, TimeUnit.MILLISECONDS);
        }


    }

    void evaluation() {

    }


    @FXML
    void quitAndSave(ActionEvent event) {
        outputLabel1.setText("To start press Start New Game");
        outputLabel2.setText("");
        newGame.setVisible(true);
        generateBtn.setVisible(false);
        quitBtn.setVisible(false);
        gameOver = true;
        highScore.save(calculation.getCurrentAmount());
        highScoreLabel.setText("High score:" + highScore.getHighScore());
    }


    @FXML
    void newGame(ActionEvent event) {
        newGame.setVisible(false);
        generateBtn.setVisible(true);

        calculation = new Calculation();
        gameOver = false;

        outputLabel1.setText("");
        outputLabel2.setText(calculation.getCurrentAmount());

    }

    @FXML
    void setCoins(ActionEvent event) {
        calculation.setStartAmount(20);
    }

    @FXML
    void goToMenu(ActionEvent event) throws Exception {
        Parent blah = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
