package com.kodilla.rps;

import java.util.Random;

public class Game {

    public static final String COMPUTER = "COMPUTER";
    public static final String HUMAN = "HUMAN";
    public static final String NOBODY = "NOBODY";
    public static Boolean QUIT_GAME = false;
    public static Boolean NEW_GAME = false;
    public static Boolean GAME_OVER = false;

    private int roundQuantity;
    private int currentRound;
    private String difficulty;

    private int humanScore, computerScore;
    private UserCommunication userCommunication = new UserCommunication();


    Game() {
    }

    public void initGame(){
        GameParameters gp = userCommunication.initGame();
        roundQuantity = gp.getRoundQuantity();
        difficulty = gp.getDifficulty();

        Game.NEW_GAME = false;
        Game.GAME_OVER = false;
        currentRound = 0;
        humanScore = 0;
        computerScore = 0;
    }

    private boolean playOneGame() {
        String userSelection = userCommunication.getUserSelection(GAME_OVER);
        if(userSelection.equals(UserCommunication.QUIT)) {
            QUIT_GAME = true;
            return false;
        }
        if(userSelection.equals(UserCommunication.NEWGAME)) {
            NEW_GAME = true;
            return false;
        }

        String computerSelection = generateSelection(userSelection, difficulty);
        String winner = selectWinner(userSelection, computerSelection);

        if (winner.equals(HUMAN)) {
            humanScore++;
            System.out.println("Player wins!");
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
        if (userSelection.equals(UserCommunication.ROCK)) {
            switch (computerSelection) {
                case UserCommunication.ROCK: return NOBODY;
                case UserCommunication.PAPER: return COMPUTER;
                case UserCommunication.SCISSORS: return HUMAN;
            }

        } else if (userSelection.equals(UserCommunication.PAPER)) {
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

    private String generateSelection(String userSelection, String difficulty) {
        Random rnd = new Random();
        int rndValue = 0;
        int[] array = {};
        int[] easyArray = {0,1,2,2,0,0,1,2,0,1,1,2};
        int[] hardArray = {0,1,1,2,0,1,2,2,0,0,1,2};

        switch (difficulty) {
            case UserCommunication.EASY:
                array = easyArray;
                break;
            case UserCommunication.HARD:
                array = hardArray;
                break;
        }

        if (!difficulty.equals(UserCommunication.MEDIUM)) {
            if (userSelection.equals(UserCommunication.ROCK)) {
                rndValue = array[rnd.nextInt(4)];
            }
            if (userSelection.equals(UserCommunication.PAPER)) {
                rndValue = array[rnd.nextInt(4) + 4];
            }
            if (userSelection.equals(UserCommunication.SCISSORS)) {
                rndValue = array[rnd.nextInt(4) + 8];
            }
        } else {
            rndValue = rnd.nextInt(3);
        }

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
        System.out.println("-->  Type N to New Game or Q to Quit <--");

        while (currentRound < roundQuantity  && playOneGame()) {
            System.out.println("Round: "+ currentRound+"/"+roundQuantity);
            System.out.print("Current scoring:");
            System.out.print(" Computer " + computerScore);
            System.out.println(" : " + humanScore + " Player");
            System.out.println("----------------------------------------");

            if (currentRound == roundQuantity) {

                System.out.print("Game Over: ");
                if (computerScore > humanScore){
                    System.out.println("Computer wins: "
                            + computerScore + " : " + humanScore);
                } else if (humanScore > computerScore) {
                    System.out.println("Player wins: "
                            + humanScore + " : " + computerScore);
                } else {
                    System.out.println("Nobody wins, tie: "
                            + humanScore + " : " + computerScore );
                }
                System.out.println("----------------------------------------");

                GAME_OVER = true;
                playOneGame();
            }
        }
    }
}