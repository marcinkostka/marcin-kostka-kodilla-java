package com.kodilla.rps;

public class GameParameters {

    private String userName;
    private int roundQuantity;

    public GameParameters(String userName, int roundQuantity) {
        this.userName = userName;
        this.roundQuantity = roundQuantity;
    }

    public String getUserName() {
        return userName;
    }

    public int getRoundQuantity() {
        return roundQuantity;
    }
}
