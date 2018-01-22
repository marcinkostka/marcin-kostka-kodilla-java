package com.kodilla.rps;

import java.util.Scanner;

public class UserCommunication {

    public static final String ROCK = "R";
    public static final String PAPER = "P";
    public static final String SCISSORS = "S";
    public static final String QUIT = "Q";

    public GameParameters initGame(){
        System.out.print("Enter human name: ");
        Scanner input = new Scanner(System.in);
        String userName = input.next();
        System.out.print("Enter rounds number: ");
        int roundQuantity = input.nextInt();

        return new GameParameters(userName, roundQuantity);
    }

    public String getUserSelection() {
        String userSelection;

        while (true) {
            System.out.println("Enter your selection: (R)ock, (P)aper, (S)cissors or type Q to quit");
            Scanner scanner = new Scanner(System.in);
            userSelection = scanner.nextLine().toUpperCase();

            switch (userSelection){
                case ROCK:
                    System.out.println("User selected ROCK");
                    return ROCK;
                case PAPER:
                    System.out.println("User selected PAPER");
                    return PAPER;
                case SCISSORS:
                    System.out.println("User selected SCISSORS");
                    return SCISSORS;
                case QUIT:
                    System.out.println("User selected QUIT");
                    return QUIT;
                default:
                    System.out.println("Wrong selection");
            }
        }
    }
}
