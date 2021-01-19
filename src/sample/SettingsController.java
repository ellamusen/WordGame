package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
            this.isGenerated = true;
            this.isCustom = false;

            this.isGeneratedBtn.getStyleClass().add("active");
            this.isCustomBtn.getStyleClass().remove("active");
            this.isCustomBtn.getStyleClass().add("settingsButton");

        }
        if (value.equals("Custom")) {
            this.isCustom = true;
            this.isGenerated = false;

            this.isCustomBtn.getStyleClass().add("active");
            this.isGeneratedBtn.getStyleClass().remove("active");
            this.isGeneratedBtn.getStyleClass().add("settingsButton");
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
        if  (value.equals("None")) {
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
        System.out.println("\n");
        System.out.println("Words:");
        System.out.println("Generated: " + this.isGenerated);
        System.out.println("Custom: " + this.isCustom);
        System.out.println("\t");
        System.out.println("New words each rounds:");
        System.out.println("Automatic: " + this.isAutomatic);
        System.out.println("Manual: " + this.isManual);
        System.out.println("\t");
        System.out.println("Lives:");
        System.out.println("Five lives: " + this.livesFive);
        System.out.println("Ten lives: " + this.livesTen);
        System.out.println("Fifteen lives: " + this.livesFifteen);
        System.out.println("None: " + this.livesNone);
    }
}
