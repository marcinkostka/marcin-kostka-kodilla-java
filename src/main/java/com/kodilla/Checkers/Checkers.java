package com.kodilla.Checkers;

import java.util.Scanner;

public class Checkers {
    public static void main(String[] args) {

        Board board = new Board();
        board.initBoard(board);
        System.out.println(board);
        System.out.println("Move: white.\nType coords in format A1B2 to move or Q to quit");

        boolean gameFinished = false;

        while(!gameFinished) {
            Scanner input = new Scanner(System.in);
            String coords = input.next();
            if (coords.substring(0,1).equals("Q")) {
                System.out.println("\nYou have quit the game");
                gameFinished = true;
            } else {
                if (coords.length() == 4){
                    Move m = Move.convertCoords(coords, board);
                    board.move(m.getX1(),m.getY1(),m.getX2(),m.getY2());
                } else {
                    System.out.println(board);
                    System.out.println("Set correct coords, in format A1B2 to move or Q to quit\n");
                }
            }
        }

/*
        board.move(1,1,2,2);
        board.move(0,6,1,5);
        System.out.println("test");

        board.move(2,2,3,3);
        board.move(5,5,4,4);
        System.out.println("test");
        board.move(3,1,4,2);
        board.move(4,4,2,2);
        board.move(4,2,3,1);
        System.out.println("test");
*/

    }
}
