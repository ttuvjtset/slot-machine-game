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

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int SEVEN_HUNDERT = 700;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int FIVE_HUNDERT = 500;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_SEVENTY = 270;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_THERTY = 230;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_HUNDRET = 200;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int ONE_EIGHTY = 180;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int ONE_SEVENTY = 170;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int ONE_EIGHTY_FIVE = 185;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int ONE_NINTY = 190;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int ONE_NINTY_FIVE = 195;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_TEN = 210;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_TWENTY_FIVE = 225;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TWO_EIGHTY = 280;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THREE_TWENTY = 320;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THREE_FIFTY = 350;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int NINE_HUNDRED = 900;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int EIGHT_HUNDRED = 800;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THOUSAND_SEVEN_HUNDRED = 1700;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int THOUSAND_TWO_HUNDRED = 1200;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final double HUNDRED = 100.0;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int EIGHTY = 80;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int FORTY = 40;

    /**
     * ImageView.
     */
    private ImageView imageView;

    /**
     * ImageView.
     */
    private ImageView imageView2;

    /**
     * ImageView.
     */
    private ImageView imageView3;

    /**
     * ImageView.
     */
    private ImageView imageView4;

    /**
     * Image.
     */
    private Image firstImage;

    /**
     * Image image randomly selected.
     */
    private Image imageRandomlySelected;

    /**
     * String Eandomly generated image filename.
     */
    private String randomlyGeneratedImageFilename;


    /**
     * Set X position.
     */
    private int setXPosition;

    /**
     * Central Y Position.
     */
    private int centralYPosition;

    /**
     * Top Y Position.
     */
    private int topYPosition;

    /**
     * Bottom Y Position.
     */
    private int bottomYPosition;


    /**
     * Status of animation finished.
     */
    private boolean animationFinished = false;

    /**
     * Catalogue ArrayList.
     */
    private ArrayList<String> catalogue;

    /**
     * Sequential translation.
     */
    private SequentialTransition sequentialTranslation;

    /**
     * Constructor.
     *
     * @param imageView        ImageView for applying maximum blur.
     * @param imageView2       ImageView for applying average blur.
     * @param imageView3       ImageView for applying minimum blur.
     * @param imageView4       ImageView for applying no blur.
     * @param setXPosition     manual refining for x position.
     * @param centralYPosition central Y position for animation.
     * @param topYPosition     top Y position for animation.
     * @param bottomYPosition  bottom Y position for animation.
     * @param catalogue        catalogue ArrayList for generating random.
     */
    public GameDrawReel(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                        int setXPosition, int centralYPosition, int topYPosition,
                        int bottomYPosition, ArrayList catalogue) {
        this.imageView = imageView; // maximum blur
        this.imageView2 = imageView2; // average blur
        this.imageView3 = imageView3; // minimum blur
        this.imageView4 = imageView4; // no blur

        this.centralYPosition = centralYPosition;
        this.topYPosition = topYPosition;
        this.bottomYPosition = bottomYPosition;
        this.setXPosition = setXPosition;
        this.catalogue = catalogue;
        firstImage = randomImage();
        positionateImageViews();
        setBlur();
    }

    /**
     * Is Animation Finished - boolean status.
     *
     * @return boolean status.
     */
    public boolean isAnimationFinished() {
        return animationFinished;
    }

    /**
     * Set the right position for ImageViews.
     */
    public void positionateImageViews() {
        imageView.setTranslateX(setXPosition);
        imageView.setTranslateY(topYPosition - 30);
        imageView2.setTranslateX(setXPosition);
        imageView2.setTranslateY(topYPosition - 30);
        imageView3.setTranslateX(setXPosition);
        imageView3.setTranslateY(topYPosition - 30);
        imageView4.setTranslateX(setXPosition);
        imageView4.setTranslateY(topYPosition - 30);
    }

    /**
     * Set blur effect on ImageViews.
     */
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

    /**
     * Show the first image when game starts.
     */
    public void initialize() {
        imageView4.setTranslateY(centralYPosition);
        imageView4.setImage(firstImage);
    }

    /**
     * When person presses on PLAY / SPIN button.
     *
     * @return randomlyGeneratedImageFilename.
     */
    public String generateAndPlay() {
        randomlyGeneratedImageFilename = randomFilename();
        imageRandomlySelected = new Image(new File(randomlyGeneratedImageFilename).toURI().toString());
        generateAnimation();
        sequentialTranslation.play();
        firstImage = imageRandomlySelected;
        return randomlyGeneratedImageFilename;
    }

    /**
     * Method for generating animations.
     */
    public void generateAnimation() {
        animationFinished = false;

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView4.imageProperty(), firstImage), new KeyValue(imageView4.translateYProperty(), centralYPosition)),
                new KeyFrame(Duration.millis(SEVEN_HUNDERT * generateRandomNumber()), new KeyValue(imageView4.imageProperty(), firstImage), new KeyValue(imageView4.translateYProperty(), bottomYPosition)));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(FIVE_HUNDERT * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline3 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_SEVENTY * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline4 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_THERTY * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline5 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_HUNDRET * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline6 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_EIGHTY * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline7 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_SEVENTY * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline8 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_SEVENTY * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline9 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_EIGHTY * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline10 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_EIGHTY_FIVE * generateRandomNumber()), new KeyValue(imageView.imageProperty(), randomImage()), new KeyValue(imageView.translateYProperty(), bottomYPosition)));
        Timeline timeline11 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_NINTY * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline12 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(ONE_NINTY_FIVE * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline13 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_HUNDRET * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline14 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_TEN * generateRandomNumber()), new KeyValue(imageView2.imageProperty(), randomImage()), new KeyValue(imageView2.translateYProperty(), bottomYPosition)));
        Timeline timeline15 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_TWENTY_FIVE * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline16 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(TWO_EIGHTY * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline17 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(THREE_TWENTY * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline18 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(THREE_FIFTY * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline19 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(FIVE_HUNDERT * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline20 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(NINE_HUNDRED * generateRandomNumber()), new KeyValue(imageView3.imageProperty(), randomImage()), new KeyValue(imageView3.translateYProperty(), bottomYPosition)));
        Timeline timeline21 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), topYPosition)),
                new KeyFrame(Duration.millis(NINE_HUNDRED * generateRandomNumber()), new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), centralYPosition + 20)));
        Timeline timeline22 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), centralYPosition + 20)),
                new KeyFrame(Duration.millis(EIGHT_HUNDRED * generateRandomNumber()), new KeyValue(imageView4.imageProperty(), imageRandomlySelected), new KeyValue(imageView4.translateYProperty(), centralYPosition)));

        sequentialTranslation = new SequentialTransition(timeline1, timeline2, timeline3, timeline4, timeline5, timeline6, timeline7, timeline8,
                timeline9, timeline10, timeline11, timeline12, timeline13, timeline14, timeline15, timeline16, timeline17, timeline18, timeline19,
                timeline20, timeline21, timeline22);

        System.out.println("Duration:" + sequentialTranslation.getTotalDuration());

        sequentialTranslation.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                animationFinished = true;
                System.out.println("finished!");
            }
        });
    }

    /**
     * @return
     */
    public String randomFilename() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(catalogue.size());
        String it = catalogue.get(index);
        return it;
    }

    /**
     * Get randomly generated image filename.
     *
     * @return randomly generated image filename.
     */
    public String getRandomlyGeneratedImageFilename() {
        return randomlyGeneratedImageFilename;
    }

    /**
     * Randomize images for animation purposes.
     *
     * @return Image.
     */
    public Image randomImage() {
        // for animation purpose
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(catalogue.size());
        String it = catalogue.get(index);
        return new Image(new File(it).toURI().toString());
    }

    /**
     * Check if animation is considered skippable (when person presses stop button).
     *
     * @return boolean status.
     */
    public boolean skippibleAnimation() {
        Duration currentTime = sequentialTranslation.getCurrentTime();
        Duration minimumAmountOfAnimation = Duration.millis(THOUSAND_SEVEN_HUNDRED);
        return currentTime.compareTo(minimumAmountOfAnimation) > 0;
    }

    /**
     * Skip the animation if possible (skippible).
     */
    public void skipAnimation() {
        if (skippibleAnimation()) {
            sequentialTranslation.jumpTo(sequentialTranslation.getTotalDuration().subtract(Duration.millis(THOUSAND_TWO_HUNDRED))); // 1200
        }
    }

    /**
     * Generate ranodm number for little differences in ms while animating.
     *
     * @return random number from 0.80-1.20
     */
    public double generateRandomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(FORTY) + EIGHTY;
        System.out.println(randomNumber / HUNDRED);
        return randomNumber / HUNDRED;
    }
}
