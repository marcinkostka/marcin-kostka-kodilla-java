package com.kodilla.rps;

import java.util.Random;

public class Game {

    public static final String COMPUTER = "COMPUTER";
    public static final String HUMAN = "HUMAN";
    public static final String NOBODY = "NOBODY";

    private String userName;
    private int roundQuantity;
    private int currentRound;

    private int userScore, computerScore;
    UserCommunication userCommunication = new UserCommunication();


    public Game() {
    }

    public void initGame(){
        GameParameters gp = userCommunication.initGame();
        userName = gp.getUserName();
        roundQuantity = gp.getRoundQuantity();

    }

    public boolean playOneGame() {
        String userSelection = userCommunication.getUserSelection();
        if(userSelection.equals(UserCommunication.QUIT)) {
            currentRound = roundQuantity;
            return false;
        }

        String computerSelection = generateSelection();
        String winner = selectWinner(userSelection, computerSelection);
        if (winner.equals(HUMAN)) {
            userScore++;
            System.out.println("Human wins!");
        } else if (winner.equals(COMPUTER)) {
            computerScore++;
            System.out.println("Computer wins!");
        } else {
            System.out.println("Nobody wins");
        }

        currentRound++;
        return true;
    }

    private String selectWinner(String userSelection, String computerSelection) {
        if (userSelection.equals(userCommunication.ROCK)) {
            switch (computerSelection) {
                case UserCommunication.ROCK: return NOBODY;
                case UserCommunication.PAPER: return COMPUTER;
                case UserCommunication.SCISSORS: return HUMAN;
            }

        } else if (userSelection.equals(userCommunication.PAPER)) {
            switch (computerSelection) {
                case UserCommunication.SCISSORS: return COMPUTER;
                case UserCommunication.ROCK: return HUMAN;
                case UserCommunication.PAPER: return NOBODY;
            }

        } else {
            switch (computerSelection) {
                case UserCommunication.PAPER: return HUMAN;
                case UserCommunication.SCISSORS: return NOBODY;
                case UserCommunication.ROCK: return COMPUTER;
            }
        }
        return null;
    }

    private String generateSelection() {
        Random rnd = new Random();
        int rndValue = rnd.nextInt(3);
        switch (rndValue) {
            case 0:
                System.out.println("Computer selected ROCK");
                return UserCommunication.ROCK;
            case 1:
                System.out.println("Computer selected PAPER");
                return UserCommunication.PAPER;
            case 2:
                System.out.println("Computer selected SCISSORS");
                return UserCommunication.SCISSORS;
            default: return null;
        }
    }

    public void playGame() {
        while (currentRound < roundQuantity  && playOneGame()) {
            System.out.println("Round: "+ currentRound+"/"+roundQuantity);
            System.out.println("Current scoring: ");
            System.out.println("Computer: " + computerScore);
            System.out.println("Human: " + userScore);
        }

    }
}
