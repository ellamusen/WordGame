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
    private boolean  livesTen;

    @FXML
    private Button livesFiveBtn;
    private boolean livesFive;

    @FXML
    void setWords(ActionEvent event) {
        System.out.println("setWords");
        System.out.println(((Button)event.getSource()).getText());
    }

    @FXML
    void setEachRounds(ActionEvent event) {

    }

    @FXML
    void setLives(ActionEvent event) {

    }

    @FXML
    void startGame(ActionEvent event) {

    }
}
