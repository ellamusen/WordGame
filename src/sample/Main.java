package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("introduction.fxml"));
        primaryStage.setTitle("Word game!");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.getScene().getStylesheets().add("/assets/game.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// linear-gradient(to left, ##FF9327,##FFB552);