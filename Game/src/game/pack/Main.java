package game.pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("GameUI.fxml"));
        primaryStage.setTitle("Slot Machine");
        primaryStage.setScene(new Scene(root, 1200, 900));
        primaryStage.getIcons().add(new Image("file:Game/src/ui_images/icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
