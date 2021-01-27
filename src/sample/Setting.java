package sample;

import java.io.Serializable;

public class Setting implements Serializable {

    private String words;
    private String rounds;
    private int lives;

    Setting() {
    };

    Setting(String words,String rounds,int lives) {
        this.words = words;
        this.rounds = rounds;
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "Words: " + words + "\nRounds: " + rounds + "\nLives: " + lives;
    }
}
