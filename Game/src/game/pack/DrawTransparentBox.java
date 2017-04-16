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


public class DrawTransparentBox {
    private static final int W = 1200;

    private Image frozenImage;

    private ImageView imageViewDeactivateBackground;

    private ImageView imageViewBlurredBox;

    private Button goToMenuBtn;

    private int layoutY;

    private int windowX;

    private int windowY;

    private int windowW;

    private int windowH;

    private double brightness;


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

    public FadeTransition generateFadeTransition(){
        // background
        prepareImage(imageViewDeactivateBackground);
        imageViewDeactivateBackground.setImage(frozenImage);

        // goToMenu Button
        if (goToMenuBtn != null) {
            goToMenuBtn.setTranslateX(500);
            goToMenuBtn.setTranslateY(-140); // 65
            goToMenuBtn.setStyle("-fx-font-size: 20pt;");
        }

        // transparent Box
        prepareImage(imageViewBlurredBox);
        Rectangle clipShape = new Rectangle(windowX, windowY, windowW, windowH);
        clipShape.setArcHeight(50); // rounded edges
        clipShape.setArcWidth(50); // rounded edges
        imageViewBlurredBox.setClip(clipShape);
        imageViewBlurredBox.setImage(frozenImage);

        BoxBlur bb = new BoxBlur(70, 70, 3);
        ColorAdjust ca = new ColorAdjust(0, 0.03, brightness, 0.05);
        bb.setInput(ca);
        imageViewBlurredBox.setEffect(bb);

        FadeTransition ft0 = new FadeTransition(Duration.millis(500), imageViewBlurredBox);
        ft0.setFromValue(0.0);
        ft0.setToValue(1.0);

        return ft0;
    }

    public void prepareImage(ImageView iw){
        iw.setLayoutX(0);
        iw.setLayoutY(layoutY);
        iw.setFitHeight(W);
        iw.setFitWidth(W);
        iw.setPreserveRatio(true);
    }
}
