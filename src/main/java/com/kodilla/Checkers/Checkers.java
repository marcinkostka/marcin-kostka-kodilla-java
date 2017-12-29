package com.kodilla.Checkers;

public class Checkers {
    public static void main(String[] args) {

        Board board = new Board();
        board.setFigure(0,0, new Pawn("B"));
        board.setFigure(1,1, new Pawn("B"));
        board.setFigure(0,2, new Pawn("B"));
        board.setFigure(5,4, new Queen("B"));

        System.out.println(board);
    }
}
