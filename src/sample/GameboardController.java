package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameboardController implements Initializable {

     private ArrayList<String> words = new ArrayList<>();
     private ArrayList<Character> wrongLetters = new ArrayList<>();
     private String chosenWord;
     private int lives = 10;

    @FXML
    private Text letterOne,letterTwo,letterThree,letterFour,letterFive,letterSix,wrongLettersBox,livesDisplay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FileInputStream fi = null;
        try {
            fi = new FileInputStream(new File("Settings.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            Setting settings = (Setting) oi.readObject();

            if (settings.getWords().equals("Generated")) {
                words.add("career");
                words.add("dollar");
                words.add("detail");
                words.add("domain");
                words.add("employ");
                words.add("empire");
                words.add("estate");
            }
            else {
                words.add("Hejhej");
            }

            if (settings.getRounds().equals("Automatic")) {

            }

            System.out.println(settings.toString());

            oi.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



        int randomInt = (int)(words.size() * Math.random());
        chosenWord = words.get(randomInt);
        System.out.println(chosenWord);

        letterOne.fillProperty().setValue(Paint.valueOf("white"));
        letterTwo.fillProperty().setValue(Paint.valueOf("white"));
        letterThree.fillProperty().setValue(Paint.valueOf("white"));
        letterFour.fillProperty().setValue(Paint.valueOf("white"));
        letterFive.fillProperty().setValue(Paint.valueOf("white"));
        letterSix.fillProperty().setValue(Paint.valueOf("white"));

        letterOne.setText(String.valueOf(chosenWord.charAt(0)));
        letterTwo.setText(String.valueOf(chosenWord.charAt(1)));
        letterThree.setText(String.valueOf(chosenWord.charAt(2)));
        letterFour.setText(String.valueOf(chosenWord.charAt(3)));
        letterFive.setText(String.valueOf(chosenWord.charAt(4)));
        letterSix.setText(String.valueOf(chosenWord.charAt(5)));

        updateLives(lives);

    }

    private void updateLives(int lives) {
        this.lives = lives;
        livesDisplay.setText(String.valueOf(lives));
    }

    @FXML
    void handleKeyPressed(KeyEvent event) {
        System.out.println(chosenWord);

        boolean foundWord = false;
        String wrongWords = "";
        for (int i = 0; i < chosenWord.length(); i++) {
            if (event.getText().equals(String.valueOf(chosenWord.charAt(i)))) {
                foundWord = true;
                System.out.println("You typed: " + event.getText());
                System.out.println("Index: " + i);

                switch (i) {
                    case 0: {
                        letterOne.fillProperty().setValue(Paint.valueOf("black"));
                        break;
                    }
                    case 1: {
                        letterTwo.fillProperty().setValue(Paint.valueOf("black"));
                        break;
                    }
                    case 2: {
                        letterThree.fillProperty().setValue(Paint.valueOf("black"));
                        break;
                    }
                    case 3: {
                        letterFour.fillProperty().setValue(Paint.valueOf("black"));
                        break;
                    }
                    case 4: {
                        letterFive.fillProperty().setValue(Paint.valueOf("black"));
                        break;
                    }
                    case 5: {
                        letterSix.fillProperty().setValue(Paint.valueOf("black"));
                        break;
                    }
                }
            }
        }

        if (!foundWord && !wrongLetters.contains(event.getText().charAt(0))) {
            wrongLetters.add(event.getText().toCharArray()[0]);

            for (int i = 0; i < wrongLetters.size(); i++) {
                if (i == 0) {
                    wrongWords += wrongLetters.get(i);
                } else {
                    wrongWords += ", " + wrongLetters.get(i);
                }

            }
            wrongLettersBox.setText(wrongWords);
            updateLives(this.lives - 1);
        }
    }
}
