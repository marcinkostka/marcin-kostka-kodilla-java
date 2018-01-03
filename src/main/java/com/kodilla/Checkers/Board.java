package com.kodilla.Checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    public String color = "W";
    public Board(){
        for (int i=0; i<8; i++){
            rows.add(new BoardRow());
        }
    }

    public String getColor() {
        return color;
    }

    Figure getFigure(int x, int y){
        return rows.get(y).getFigure(x);
    }

    void setFigure(int x, int y, Figure f){
        rows.get(y).setFigure(x,f);
    }

    void initBoard(Board board){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++){
                if (col % 2 == row % 2 && row < 2) {
                    board.setFigure(col, row, new Pawn("W"));
                } else if (col % 2 == row % 2 && row > 5) {
                    board.setFigure(col, row, new Pawn("B"));
                }
            }
        }
    }

    boolean isMoveAvailable(int x1, int y1, int x2, int y2){
        Move m = new Move(x1, y1, x2, y2, this);
        List<Move> movesList = m.availableMoveList();
        return movesList.contains(m);
    }

    void move(int x1, int y1, int x2, int y2){
        if (isMoveAvailable(x1,y1,x2,y2)){
            Figure figure = getFigure(x1,y1);
            setFigure(x1, y1, new None());
            setFigure(x2, y2, figure);
            System.out.println(this);
            //nowa tura - zmiana wykonujacego ruch
            if (color == "W"){
                System.out.println("Move: black.\nType coords in format A1B2 to move or Q to quit");
                color = "B";
            } else {
                color = "W";
                System.out.println("Move: white.\nType coords in format A1B2 to move or Q to quit");
            }
        } else {
            System.out.println(this);
            System.out.println("Move is not available\n");
        }
    }

    @Override
    public String toString(){
        String board = "__|A |B |C |D |E |F |G |H |\n";
        Figure figure = null;

        for (int y=0; y<8; y++){
            //draw 1-8 numbers
            board = board + (y+1) + " |";

            for (int x=0; x<8; x++){
                figure = getFigure(x,y);
                board = board + figure.getColor();

                if(figure instanceof Pawn){
                    board = board + "P";
                } else if (figure instanceof Queen) {
                    board = board + "Q";;
                } else {
                    board = board + " ";
                }

                board = board + "|";
            }
            board = board + "\n";
        }
        return board;
    }
}
