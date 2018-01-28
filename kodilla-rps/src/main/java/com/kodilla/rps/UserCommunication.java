package com.kodilla.rps;

import java.util.Scanner;

public class UserCommunication {

    public static final String ROCK = "R";
    public static final String PAPER = "P";
    public static final String SCISSORS = "S";
    public static final String QUIT = "Q";
    public static final String NEWGAME = "N";
    public static final String EASY = "E";
    public static final String MEDIUM = "M";
    public static final String HARD = "H";

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public GameParameters initGame() {
        System.out.print("Enter human name: ");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        System.out.print("Enter rounds number: ");
        int roundQuantity;

        while (true) {
            String tmpInput = input.nextLine();
            if (isInteger(tmpInput)){
                roundQuantity = Integer.parseInt(tmpInput);
                if (roundQuantity > 0) {
                    break;
                } else {
                    System.out.println("--> Rounds must be greater than ZERO ! <--");
                    System.out.print("Enter correct rounds number: ");
                }
            } else {
                System.out.println("--> It's not a number ! <--");
                System.out.print("Enter correct rounds number: ");
            }
        }

        String difficulty = null;
        boolean difficultySelected = false;

        while (!difficultySelected){
            System.out.print("Select a game difficulty " +
                    "(E)asy, (M)edium, (H)ard: ");
            difficulty = input.next().toUpperCase();

            switch (difficulty) {
                case EASY:
                    System.out.println("Player selected EASY");
                    difficulty = EASY;
                    difficultySelected = true;
                    break;
                case MEDIUM:
                    System.out.println("Player selected MEDIUM");
                    difficulty = MEDIUM;
                    difficultySelected = true;
                    break;
                case HARD:
                    System.out.println("Player selected HARD");
                    difficulty = HARD;
                    difficultySelected = true;
                    break;
                default:
                        System.out.println("Wrong selection");
            }
        }

        return new GameParameters(userName, roundQuantity, difficulty);
    }

    public String getUserSelection(Boolean gameOver) {
        String userSelection;

        while (!gameOver) {
            System.out.println("Enter your selection: (R)ock, (P)aper, (S)cissors");
            Scanner scanner = new Scanner(System.in);
            userSelection = scanner.nextLine().toUpperCase();

            switch (userSelection) {
                case ROCK:
                    System.out.println("Player selected ROCK");
                    return ROCK;
                case PAPER:
                    System.out.println("Player selected PAPER");
                    return PAPER;
                case SCISSORS:
                    System.out.println("Player selected SCISSORS");
                    return SCISSORS;
                case QUIT:
                    System.out.println("Player selected QUIT");
                    return QUIT;
                case NEWGAME:
                    System.out.println("Player selected NEW GAME");
                    return NEWGAME;
                default:
                    System.out.println("Wrong selection");
            }
        }

        while (gameOver) {
            System.out.print("Enter your selection (N)ew Game or (Q)uit: ");
            Scanner scanner = new Scanner(System.in);
            userSelection = scanner.nextLine().toUpperCase();

            switch (userSelection) {
                case QUIT:
                    System.out.println("User selected QUIT");
                    return QUIT;
                case NEWGAME:
                    System.out.println("User selected NEW GAME");
                    return NEWGAME;
                default:
                    System.out.println("Wrong selection");
            }
        }
        return null;
    }
}
