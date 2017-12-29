package com.kodilla.Checkers;

public class Checkers {
    public static void main(String[] args) {

        Board board = new Board();
        board.setFigure(0,0, new Pawn("B"));
        board.setFigure(2,0, new Pawn("B"));
        board.setFigure(1,1, new Pawn("B"));
        board.setFigure(5,4, new Queen("B"));

        System.out.println(board);

        board.move(5,4,5,1);
        System.out.println(board);
    }
}
