package game.pack;

import javafx.animation.FadeTransition;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 */
public class DrawTransparentBox {

    /**
     *
     */
    private static final int W = 1200;

    /**
     * MAGIC NUMBER.
     */
    public static final int FIVE_HUNDERT_MS = 500;

    /**
     * MAGIC NUMBER.
     */
    public static final int SEVENTY = 70;

    /**
     * MAGIC NUMBER.
     */
    public static final int THREE = 3;

    /**
     * MAGIC NUMBER.
     */
    public static final int FIFTY = 50;

    /**
     * MAGIC NUMBER.
     */
    public static final int FIVE_HUNDERT = 500;

    /**
     * MAGIC NUMBER.
     */
    public static final int MINUS_ONE_HUNDERT_FORTY = -140;

    /**
     * screenshot of the background
     */
    private Image frozenImage;

    /**
     * imageViewDeactivateBackground. >> background.
     */
    private ImageView imageViewDeactivateBackground;

    /**
     * imageViewBlurredBox. >> for the box itself.
     */
    private ImageView imageViewBlurredBox;

    /**
     * go to menu button.
     */
    private Button goToMenuBtn;

    /**
     * Y position for background and window itself.
     */
    private int layoutY;

    /**
     * window X position.
     */
    private int windowX;

    /**
     * window Y position.
     */
    private int windowY;

    /**
     * window width.
     */
    private int windowW;

    /**
     * window height.
     */
    private int windowH;

    /**
     * brightness.
     */
    private double brightness;


    /**
     * Constructor.
     *
     * @param ap                            AnchorPane.
     * @param imageViewDeactivateBackground imageViewDeactivateBackground. >> background.
     * @param imageViewBlurredBox           imageViewBlurredBox. >> for the box itself.
     * @param goToMenuBtn                   go to menu button as object.
     * @param layoutY                       Y position for background and window itself.
     * @param windowX                       window X position.
     * @param windowY                       window Y position.
     * @param windowW                       window width.
     * @param windowH                       window height.
     * @param brightness
     */
    public DrawTransparentBox(AnchorPane ap, ImageView imageViewDeactivateBackground, ImageView imageViewBlurredBox, Button goToMenuBtn, int layoutY, int windowX, int windowY, int windowW, int windowH, double brightness) {
        frozenImage = ap.snapshot(new SnapshotParameters(), null);
        this.imageViewDeactivateBackground = imageViewDeactivateBackground;
        this.imageViewBlurredBox = imageViewBlurredBox;
        this.goToMenuBtn = goToMenuBtn;
        this.layoutY = layoutY;
        this.windowX = windowX;
        this.windowY = windowY;
        this.windowW = windowW;
        this.windowH = windowH;
        this.brightness = brightness;
    }

    /**
     * Generation of fade transition.
     *
     * @return FadeTransition.
     */
    public FadeTransition generateFadeTransition() {
        // background
        prepareImage(imageViewDeactivateBackground);
        imageViewDeactivateBackground.setImage(frozenImage);

        // goToMenu Button
        if (goToMenuBtn != null) {
            goToMenuBtn.setTranslateX(FIVE_HUNDERT);
            goToMenuBtn.setTranslateY(MINUS_ONE_HUNDERT_FORTY); // 65
            goToMenuBtn.setStyle("-fx-font-size: 20pt;");
        }

        // transparent Box
        prepareImage(imageViewBlurredBox);
        Rectangle clipShape = new Rectangle(windowX, windowY, windowW, windowH);
        clipShape.setArcHeight(FIFTY); // rounded edges
        clipShape.setArcWidth(FIFTY); // rounded edges
        imageViewBlurredBox.setClip(clipShape);
        imageViewBlurredBox.setImage(frozenImage);

        BoxBlur bb = new BoxBlur(SEVENTY, SEVENTY, THREE);
        ColorAdjust ca = new ColorAdjust(0, 0.03, brightness, 0.05);
        bb.setInput(ca);
        imageViewBlurredBox.setEffect(bb);

        FadeTransition ft0 = new FadeTransition(Duration.millis(FIVE_HUNDERT_MS), imageViewBlurredBox);
        ft0.setFromValue(0.0);
        ft0.setToValue(1.0);

        return ft0;
    }

    /**
     * "Help function" for image preparation.
     *
     * @param iw ImageView.
     */
    public void prepareImage(ImageView iw) {
        iw.setLayoutX(0);
        iw.setLayoutY(layoutY);
        iw.setFitHeight(W);
        iw.setFitWidth(W);
        iw.setPreserveRatio(true);
    }
}
