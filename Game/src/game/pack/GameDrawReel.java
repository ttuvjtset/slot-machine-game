package game.pack;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;


public class GameDrawReel {
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    Image firstImage;
    Image imageRandomlySelected;
    String randomlyGeneratedImageFilename;

    int setXPosition;
    int centralYPosition;
    int topYPosition;
    int bottomYPosition;

    public boolean isAnimationFinished() {
        return animationFinished;
    }

    boolean animationFinished = false;

    ArrayList<String> catalogue;
    SequentialTransition sequentialTranslation;
    //  Image randomlyGeneratedImage;


    public GameDrawReel(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, int setXPosition, int centralYPosition, int topYPosition, int bottomYPosition, ArrayList catalogue) {
        this.imageView = imageView; // maximum blur
        this.imageView2 = imageView2; // average blur
        this.imageView3 = imageView3; // minimum blur
        this.imageView4 = imageView4; // no blur
        //this.firstImage = firstImage;
        //this.imageRandomlySelected = imageRandomlySelected;
        this.centralYPosition = centralYPosition;
        this.topYPosition = topYPosition;
        this.bottomYPosition = bottomYPosition;
        this.setXPosition = setXPosition;
        this.catalogue = catalogue;
        firstImage = randomImage();
        positionateImageViews();
        setBlur();
    }

    public void positionateImageViews() {
        imageView.setTranslateX(setXPosition);
        imageView.setTranslateY(topYPosition-30);
        imageView2.setTranslateX(setXPosition);
        imageView2.setTranslateY(topYPosition-30);
        imageView3.setTranslateX(setXPosition);
        imageView3.setTranslateY(topYPosition-30);
        imageView4.setTranslateX(setXPosition);
        imageView4.setTranslateY(topYPosition-30);
    }

    public void setBlur() {
        MotionBlur mbMax = new MotionBlur();
        mbMax.setRadius(50);
        mbMax.setAngle(90);
        imageView.setEffect(mbMax);

        MotionBlur mbAverage = new MotionBlur();
        mbAverage.setRadius(25);
        mbAverage.setAngle(90);
        imageView2.setEffect(mbAverage);

        MotionBlur mbMin = new MotionBlur();
        mbMin.setRadius(15);
        mbMin.setAngle(90);
        imageView3.setEffect(mbMin);
    }

    public void initialize() {
        imageView4.setTranslateY(centralYPosition);
        imageView4.setImage(firstImage);

    }

    public String generateAndPlay() {
        randomlyGeneratedImageFilename = randomFilename();
        imageRandomlySelected = new Image(new File(randomlyGeneratedImageFilename).toURI().toString());
        generateAnimation();
        sequentialTranslation.play();
        firstImage = imageRandomlySelected;
        return randomlyGeneratedImageFilename;
    }

    public void generateAnimation() {
        animationFinished = false;

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView4.imageProperty(), firstImage), new KeyValue(imageView4.translateYProperty(), centralYPosition)),
                new KeyFrame(Duration.millis(700 * generateRandomNumber()), new KeyValue(imageView4.imageProperty(), firstImage), new KeyValue(imageView4.translateYProperty(), bottomYPosition)));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(500 * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(270 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline4 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(230 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline5 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(200 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline6 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(180 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline7 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(170 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline8 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(170 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline9 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(180 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline10 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(185 * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline11 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(190 * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline12 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(195 * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline13 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(200 * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline14 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(210 * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline15 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(225 * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline16 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(280 * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline17 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(320 * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline18 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(350 * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline19 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(500 * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline20 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(900 * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline21 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(900 * generateRandomNumber()), new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), centralYPosition + 20)));
        Timeline timeline22 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), centralYPosition + 20)),
                new KeyFrame(Duration.millis(800 * generateRandomNumber()), new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), centralYPosition)));

        sequentialTranslation = new SequentialTransition(timeline1, timeline2, timeline3, timeline4, timeline5, timeline6, timeline7, timeline8,
                timeline9, timeline10, timeline11, timeline12, timeline13, timeline14, timeline15, timeline16, timeline17, timeline18, timeline19,
                timeline20, timeline21, timeline22);

        System.out.println("Duration:" + sequentialTranslation.getTotalDuration());

        sequentialTranslation.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //return true;
                animationFinished = true;
                //System.out.println(getClass().getSuperclass().getName());
                System.out.println("finished!");
            }
        });
    }

    public String randomFilename() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(catalogue.size());
        String it = catalogue.get(index);
        return it;
    }

    public String getRandomlyGeneratedImageFilename() {
        return randomlyGeneratedImageFilename;
    }

    public Image randomImage() {
        // for animation purpose
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(catalogue.size());
        String it = catalogue.get(index);
        return new Image(new File(it).toURI().toString());
    }


    public void skipAnimation() {
        sequentialTranslation.jumpTo(Duration.seconds(6));
    }

    public double generateRandomNumber () {
        Random rand = new Random();
        int randomNumber = rand.nextInt(40) + 80;
        System.out.println(randomNumber / 100.0);
        return randomNumber / 100.0;
    }
}
