package game.pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
        createCopyFiles();

        Font.loadFont(Main.class.getResource("lcddot.ttf").toExternalForm(), TEN);

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Slot Machine");
        primaryStage.setScene(new Scene(root, ONE_ONE_EIGHT_EIGHT, NINE_FOUR_EIGHT));
        primaryStage.getIcons().add(new Image("file:Game/src/ui_images/Joker.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public void createCopyFiles() {
        File dir = new File("Game");
        dir.mkdir();

        File dir2 = new File("Game/src");
        dir2.mkdir();

        File dir3 = new File("Game/src/images");
        dir3.mkdir();

        File dir4 = new File("Game/src/score");
        dir4.mkdir();

        File dir5 = new File("Game/src/settings");
        dir5.mkdir();

        File dir6 = new File("Game/src/ui_images");
        dir6.mkdir();


        copyFile("files/to/copy/Game/src/images/Apple.png", "Game/src/images/Apple.png");
        copyFile("files/to/copy/Game/src/images/Banana.png", "Game/src/images/Banana.png");
        copyFile("files/to/copy/Game/src/images/Cherry.png", "Game/src/images/Cherry.png");
        copyFile("files/to/copy/Game/src/images/Crystal.png", "Game/src/images/Crystal.png");
        copyFile("files/to/copy/Game/src/images/Grape.png", "Game/src/images/Grape.png");
        copyFile("files/to/copy/Game/src/images/Joker.png", "Game/src/images/Joker.png");
        copyFile("files/to/copy/Game/src/images/Lemon.png", "Game/src/images/Lemon.png");
        copyFile("files/to/copy/Game/src/images/Melon.png", "Game/src/images/Melon.png");
        copyFile("files/to/copy/Game/src/images/Orange.png", "Game/src/images/Orange.png");

        copyFile("files/to/copy/Game/src/score/score.txt", "Game/src/score/score.txt");

        copyFile("files/to/copy/Game/src/settings/settings.txt", "Game/src/settings/settings.txt");

        copyFile("files/to/copy/Game/src/ui_images/Joker.png", "Game/src/ui_images/Joker.png");


    }

    public void copyFile(String from, String to){
        InputStream ddlStream = Main.class
                .getClassLoader().getResourceAsStream(from);

        try (FileOutputStream fos = new FileOutputStream(to);){
            byte[] buf = new byte[2048];
            int r;
            while(-1 != (r = ddlStream.read(buf))) {
                fos.write(buf, 0, r);
            }
        } catch (IOException event) {
            System.out.println("Error");
        }
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
