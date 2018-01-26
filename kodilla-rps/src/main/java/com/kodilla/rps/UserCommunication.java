package com.kodilla.rps;

import java.util.Scanner;

public class UserCommunication {

    public static final String ROCK = "R";
    public static final String PAPER = "P";
    public static final String SCISSORS = "S";
    public static final String QUIT = "Q";
    public static final String NEWGAME = "N";

    public GameParameters initGame() {
        System.out.print("Enter human name: ");
        Scanner input = new Scanner(System.in);
        String userName = input.next();
        System.out.print("Enter rounds number: ");
        int roundQuantity;

        while (true) {
             roundQuantity = input.nextInt();
             if (roundQuantity <= 0) {
                 System.out.println("--> Rounds must be greater than ZERO ! <--");
                 System.out.print("Enter correct rounds number: ");
             } else {
                 break;
             }
         }

        return new GameParameters(userName, roundQuantity);
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
            System.out.println("Type N to New Game or Q to Quit");
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
