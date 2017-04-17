package game.pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main method.
 */
public class Main extends Application {

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int TEN = 10;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int ONE_ONE_EIGHT_EIGHT = 1188;

    /**
     * MASKED MAGIC NUMBER.
     */
    public static final int NINE_FOUR_EIGHT = 948;

    /**
     * Start.
     *
     * @param primaryStage primaryStage.
     * @throws Exception Exception.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Font.loadFont(Main.class.getResource("lcddot.ttf").toExternalForm(), TEN);

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Slot Machine");
        primaryStage.setScene(new Scene(root, ONE_ONE_EIGHT_EIGHT, NINE_FOUR_EIGHT));
        primaryStage.getIcons().add(new Image("file:Game/src/ui_images/Joker.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Main.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
