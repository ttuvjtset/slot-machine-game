package game.pack;

import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class AnimateDifference {

    private Label label;
    private SequentialTransition str;
    private String text;

    public AnimateDifference(AnchorPane pane, String text, int x, int y) {

        label = new Label();
        label.setVisible(false);
        pane.getChildren().add(label);
        this.text = text;
        label.setStyle("-fx-font-family: LCDDot; -fx-font-size: 60; -fx-text-fill: #aad65c;");
        label.setText(text);

        label.setLayoutX(x-100);
        label.setLayoutY(y+350);
        generateAnimation();
    }

    private void generateAnimation() {
        if(!text.equals("")){
            label.setScaleX(100);
            label.setScaleY(100);

            TranslateTransition tt0 = new TranslateTransition(Duration.millis(200), label);
            tt0.setByX(100);
            tt0.setByY(-350);

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), label);
            scaleTransition.setCycleCount(1);
            scaleTransition.setAutoReverse(true);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);

            FadeTransition ft1 = new FadeTransition(Duration.millis(170), label);
            ft1.setFromValue(0.0);
            ft1.setToValue(0.3);

            FadeTransition ft2 = new FadeTransition(Duration.millis(30), label);
            ft2.setFromValue(0.3);
            ft2.setToValue(1.0);

            SequentialTransition str0 = new SequentialTransition(ft1, ft2);

            ParallelTransition ptr = new ParallelTransition();
            ptr.getChildren().addAll(tt0, scaleTransition, str0);

            ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(300), label);
            scaleTransition2.setCycleCount(1);
            scaleTransition2.setAutoReverse(true);
            scaleTransition2.setToX(1.20);
            scaleTransition2.setToY(1.20);

            TranslateTransition pause = new TranslateTransition(Duration.seconds(5), label);

            TranslateTransition tt = new TranslateTransition(Duration.millis(100), label);
            tt.setByY(10);
            tt.setCycleCount(1);

            TranslateTransition tt2 = new TranslateTransition(Duration.millis(300), label);
            tt2.setByY(-200);
            tt2.setCycleCount(1);
            //tt.setAutoReverse(false);

            str = new SequentialTransition(ptr, scaleTransition2, pause, tt, tt2);
        }



    }

    public void playAnimation() {
        if(!text.equals("")){
            label.setVisible(true);
            str.play();
        }

    }

    public void stopAnimation() {
        if (!text.equals("")){
            str.playFrom(Duration.millis(5400));
        }
    }
}
