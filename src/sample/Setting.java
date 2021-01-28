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

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "Words: " + words + "\nRounds: " + rounds + "\nLives: " + lives;
    }
}
