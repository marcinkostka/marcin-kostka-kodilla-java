package com.kodilla.rps;

public class GameParameters {

    private String userName;
    private int roundQuantity;
    private String difficulty;

    public GameParameters(String userName, int roundQuantity, String difficulty) {
        this.userName = userName;
        this.roundQuantity = roundQuantity;
        this.difficulty = difficulty;
    }

    public String getUserName() {
        return userName;
    }

    public int getRoundQuantity() {
        return roundQuantity;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
