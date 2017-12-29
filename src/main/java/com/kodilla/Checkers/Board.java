package com.kodilla.Checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board(){
        for (int i=0; i<8; i++){
            rows.add(new BoardRow());
        }
    }

    Figure getFigure(int x, int y){
        return rows.get(y).getFigure(x);
    }

    void setFigure(int x, int y, Figure f){
        rows.get(y).setFigure(x,f);
    }

    void move(int x1, int y1, int x2, int y2){
        Figure figure = getFigure(x1,y1);
        setFigure(x1, y1, new None());
        setFigure(x2, y2, figure);
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
