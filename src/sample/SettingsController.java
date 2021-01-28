package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

public class SettingsController {

    @FXML
    private Button startGame;

    @FXML
    private Button isGeneratedBtn;
    private boolean isGenerated;

    @FXML
    private Button isCustomBtn;
    private boolean isCustom;

    @FXML
    private Button isAutomaticBtn;
    private boolean isAutomatic;

    @FXML
    private Button isManualBtn;
    private boolean isManual;

    @FXML
    private Button livesNoneBtn;
    private boolean livesNone;

    @FXML
    private Button livesFifteenBtn;
    private boolean livesFifteen;

    @FXML
    private Button livesTenBtn;
    private boolean livesTen;

    @FXML
    private Button livesFiveBtn;
    private boolean livesFive;

    @FXML
    void setWords(ActionEvent event) {
        System.out.println("setWords");
        String value = ((Button) event.getSource()).getText();
        if (value.equals("Generated")) {
            System.out.println("setEachRound");
            this.isGenerated = true; // GENERATED button is chosen
            this.isCustom = false; // CUSTOM button is not chosen
            this.isAutomatic = true; // AUTOMATIC button is chosen
            this.isManual = false; // MANUAL button is not chosen
            this.isManualBtn.setDisable(true); // Disabling the MANUAL button, when GENERATED button is chosen

            this.isGeneratedBtn.getStyleClass().add("active"); // GENERATED button turns green
            this.isCustomBtn.getStyleClass().remove("active"); // CUSTOM button removes the green color
            this.isCustomBtn.getStyleClass().add("settingsButton"); // CUSTOM button turns to default color (white)
            this.isAutomaticBtn.getStyleClass().add("deactivate1"); // AUTOMATIC button turns green-ish (indicating that it is disabled)
            this.isManualBtn.getStyleClass().add("deactivate2"); // MANUAL button turns grey-ish (indicating that it is disabled)

        }
        if (value.equals("Custom")) {
            this.isCustom = true;
            this.isGenerated = false;
            this.isManualBtn.setDisable(false);

            this.isCustomBtn.getStyleClass().add("active"); // CUSTOM button turns green
            this.isGeneratedBtn.getStyleClass().remove("active"); // GENERATED button removes the green color
            this.isGeneratedBtn.getStyleClass().add("settingsButton"); // GENERATED button turns to default color (white)
            this.isAutomaticBtn.getStyleClass().remove("deactivate1"); //
            this.isAutomaticBtn.getStyleClass().add("settingsButton");
            this.isManualBtn.getStyleClass().remove("deactivate2");
            this.isManualBtn.getStyleClass().add("settingsButton");
        }
    }

    @FXML
    void setEachRounds(ActionEvent event) {
        System.out.println("setEachRounds");
        String value = ((Button) event.getSource()).getText();
        if (value.equals("Automatic")) {
            this.isAutomatic = true;
            this.isManual = false;

            this.isAutomaticBtn.getStyleClass().add("active");
            this.isManualBtn.getStyleClass().remove("active");
            this.isManualBtn.getStyleClass().add("settingsButton");
        }
        if (value.equals("Manual")) {
            this.isManual = true;
            this.isAutomatic = false;

            this.isManualBtn.getStyleClass().add("active");
            this.isAutomaticBtn.getStyleClass().remove("active");
            this.isAutomaticBtn.getStyleClass().add("settingsButton");
        }
    }

    @FXML
    void setLives(ActionEvent event) {
        System.out.println("setLives");
        String value = ((Button) event.getSource()).getText();
        if (value.equals("5")) {
            this.livesFive = true;
            this.livesTen = false;
            this.livesFifteen = false;
            this.livesNone = false;

            this.livesFiveBtn.getStyleClass().add("active");
            this.livesTenBtn.getStyleClass().remove("active");
            this.livesTenBtn.getStyleClass().add("settingsButton");
            this.livesFifteenBtn.getStyleClass().remove("active");
            this.livesFifteenBtn.getStyleClass().add("settingsButton");
            this.livesNoneBtn.getStyleClass().remove("active");
            this.livesNoneBtn.getStyleClass().add("settingsButton");
        }
        if (value.equals("10")) {
            this.livesFive = false;
            this.livesTen = true;
            this.livesFifteen = false;
            this.livesNone = false;

            this.livesFiveBtn.getStyleClass().remove("active");
            this.livesFiveBtn.getStyleClass().add("settingsButton");
            this.livesTenBtn.getStyleClass().add("active");
            this.livesFifteenBtn.getStyleClass().remove("active");
            this.livesFifteenBtn.getStyleClass().add("settingsButton");
            this.livesNoneBtn.getStyleClass().remove("active");
            this.livesNoneBtn.getStyleClass().add("settingsButton");
        }

        if (value.equals("15")) {
            this.livesFive = false;
            this.livesTen = false;
            this.livesFifteen = true;
            this.livesNone = false;

            this.livesFiveBtn.getStyleClass().remove("active");
            this.livesFiveBtn.getStyleClass().add("settingsButton");
            this.livesTenBtn.getStyleClass().remove("active");
            this.livesTenBtn.getStyleClass().add("settingsButton");
            this.livesFifteenBtn.getStyleClass().add("active");
            this.livesNoneBtn.getStyleClass().remove("active");
            this.livesNoneBtn.getStyleClass().add("settingsButton");
        }
        if (value.equals("None")) {
            this.livesFive = false;
            this.livesTen = false;
            this.livesFifteen = false;
            this.livesNone = true;

            this.livesFiveBtn.getStyleClass().remove("active");
            this.livesFiveBtn.getStyleClass().add("settingsButton");
            this.livesTenBtn.getStyleClass().remove("active");
            this.livesTenBtn.getStyleClass().add("settingsButton");
            this.livesFifteenBtn.getStyleClass().remove("active");
            this.livesFifteenBtn.getStyleClass().add("settingsButton");
            this.livesNoneBtn.getStyleClass().add("active");
        }
    }

    @FXML
    void startGame(ActionEvent event) {

        String wordSetting = this.isGenerated ? "Generated": "Custom";
        String roundSetting = this.isAutomatic ? "Automatic": "Manual";
        int lives = 0;
        if (this.livesFive) lives = 5;
        else if (this.livesTen) lives = 10;
        else if (this.livesFifteen) lives = 15;

        Setting settings = new Setting(wordSetting, roundSetting, lives);

        try {
            FileOutputStream f = new FileOutputStream(new File("Settings.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(settings);

            o.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }


        // Pressing the Start Button
        System.out.println("The game has started!"); // A message is displayed

        try { // The try statement allows you to define a block of code to be tested for errors while it is being executed
            FXMLLoader gameboardLoader = new FXMLLoader(getClass().getResource("gameboard.fxml")); // Setting the pane to the gameboard fxml file
            Parent gameboardPane = gameboardLoader.load();
            Scene gameboardScene = new Scene(gameboardPane, 1000, 600); // Setting the size of the new pane
            gameboardScene.getRoot().requestFocus(); // Need this  to handle keyevents
            gameboardScene.getStylesheets().add("/assets/game.css"); // Added CSS file to Settings scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(gameboardScene);

        } catch (
                IOException io) { // The catch statement allows you to define a block of code to be executed, if an error occurs in the try block
            io.printStackTrace();
        }
    }
}

