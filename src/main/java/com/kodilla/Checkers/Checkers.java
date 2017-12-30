package com.kodilla.Checkers;

public class Checkers {
    public static void main(String[] args) {

        Board board = new Board();
        board.initBoard(board);
        System.out.println(board);

        /*
        board.move(1,1,2,2);
        //System.out.println(board);
        board.move(6,6,5,5);
        //System.out.println(board);

        board.move(2,2,3,3);
        board.move(5,5,4,4);
        System.out.println(board);
        board.move(3,1,4,2);
        board.move(4,4,2,2);
        board.move(4,2,3,1);
        System.out.println(board);
        */
    }
}
