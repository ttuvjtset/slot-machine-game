package game.pack;

import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Animate difference.
 */
public class AnimateDifference {
    /**
     * HUNDERT_PX.
     */
    public static final int HUNDERT_PX = 100;

    /**
     * THREE_HUNDERT_FIFTY_PX.
     */
    public static final int THREE_HUNDERT_FIFTY_PX = 350;

    /**
     * TWO_HUNDERT_MS.
     */
    public static final int TWO_HUNDERT_MS = 200;

    /**
     * MINUS_THREE_HUNDERT_FIFTY_PX.
     */
    public static final int MINUS_THREE_HUNDERT_FIFTY_PX = -350;

    /**
     * HUNDERT_SEVENTY_MS.
     */
    public static final int HUNDERT_SEVENTY_MS = 170;

    /**
     * THIRTY_MS.
     */
    public static final int THIRTY_MS = 30;

    /**
     * THREE_HUNDERT_MS.
     */
    public static final int THREE_HUNDERT_MS = 300;

    /**
     * TEN_PX.
     */
    public static final int TEN_PX = 10;

    /**
     * FIVE_SECONDS.
     */
    public static final int FIVE_SECONDS = 5;

    /**
     * FIVE_THOUSAND_FOUR_HUNDERT_MS.
     */
    public static final int FIVE_THOUSAND_FOUR_HUNDERT_MS = 5400;

    /**
     * Label to animate.
     */
    private Label label;

    /**
     * SequentialTransition.
     */
    private SequentialTransition str;

    /**
     * String with text.
     */
    private String text;

    /**
     * AnchorPane.
     */
    private AnchorPane pane;

    /**
     * Animate difference.
     *
     * @param pane pane.
     * @param text text.
     * @param x    x.
     * @param y    y.
     */
    public AnimateDifference(AnchorPane pane, String text, int x, int y) {

        label = new Label();
        label.setVisible(false);
        this.pane = pane;
        pane.getChildren().add(label);
        this.text = text;
        label.setStyle("-fx-font-family: LCDDot; -fx-font-size: 60; -fx-text-fill: #aad65c;");
        label.setText(text);

        label.setLayoutX(x - HUNDERT_PX);
        label.setLayoutY(y + THREE_HUNDERT_FIFTY_PX);
        generateAnimation();
    }

    /**
     * Generate animation.
     */
    private void generateAnimation() {
        if (!text.equals("")) {
            label.setScaleX(HUNDERT_PX);
            label.setScaleY(HUNDERT_PX);

            TranslateTransition tt0 = new TranslateTransition(Duration.millis(TWO_HUNDERT_MS), label);
            tt0.setByX(HUNDERT_PX);
            tt0.setByY(MINUS_THREE_HUNDERT_FIFTY_PX);

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(TWO_HUNDERT_MS), label);
            scaleTransition.setCycleCount(1);
            scaleTransition.setAutoReverse(true);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);

            FadeTransition ft1 = new FadeTransition(Duration.millis(HUNDERT_SEVENTY_MS), label);
            ft1.setFromValue(0.0);
            ft1.setToValue(0.3);

            FadeTransition ft2 = new FadeTransition(Duration.millis(THIRTY_MS), label);
            ft2.setFromValue(0.3);
            ft2.setToValue(1.0);

            SequentialTransition str0 = new SequentialTransition(ft1, ft2);

            ParallelTransition ptr = new ParallelTransition();
            ptr.getChildren().addAll(tt0, scaleTransition, str0);

            ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(THREE_HUNDERT_MS), label);
            scaleTransition2.setCycleCount(1);
            scaleTransition2.setAutoReverse(true);
            scaleTransition2.setToX(1.20);
            scaleTransition2.setToY(1.20);

            TranslateTransition pause = new TranslateTransition(Duration.seconds(FIVE_SECONDS), label);

            TranslateTransition tt = new TranslateTransition(Duration.millis(HUNDERT_PX), label);
            tt.setByY(TEN_PX);
            tt.setCycleCount(1);

            TranslateTransition tt2 = new TranslateTransition(Duration.millis(THREE_HUNDERT_MS), label);
            tt2.setByY(-TWO_HUNDERT_MS);
            tt2.setCycleCount(1);

            str = new SequentialTransition(ptr, scaleTransition2, pause, tt, tt2);
        }
    }

    /**
     * Play animation.
     */
    public void playAnimation() {
        if (!text.equals("")) {
            label.setVisible(true);
            str.play();
            str.setOnFinished(e -> pane.getChildren().remove(label));
        }
    }

    /**
     * Stop animation.
     */
    public void stopAnimation() {
        if (!text.equals("")) {
            str.playFrom(Duration.millis(FIVE_THOUSAND_FOUR_HUNDERT_MS));
            str.setOnFinished(e -> pane.getChildren().remove(label));
        }
    }

    /**
     * Delete animate difference label.
     */
    public void deleteAnimateDifferenceLabel() {
        label.setVisible(false);
        pane.getChildren().remove(label);
    }
}
