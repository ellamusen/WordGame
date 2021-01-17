package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroductionController {

    @FXML
    private GridPane gridPane;

    @FXML
    private Button startButton;

    //Method for startButton that takes you to another screen
    @FXML
    private void startGame(ActionEvent event) {
        System.out.println("The game has started!");

        try {
            FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("settings.fxml"));
            Parent settingsPane = settingsLoader.load();
            Scene settingsScene = new Scene(settingsPane,1000,600);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(settingsScene);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
