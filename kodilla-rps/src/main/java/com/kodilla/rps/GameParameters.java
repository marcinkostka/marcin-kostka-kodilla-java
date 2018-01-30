package com.kodilla.rps;

public class GameParameters {
    private int roundQuantity;
    private String difficulty;

    GameParameters(int roundQuantity, String difficulty) {
        this.roundQuantity = roundQuantity;
        this.difficulty = difficulty;
    }

    public int getRoundQuantity() {
        return roundQuantity;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
