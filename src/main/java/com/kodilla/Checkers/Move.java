package com.kodilla.Checkers;

import java.util.ArrayList;
import java.util.List;

public class Move {

    private int x1,x2,y1,y2;
    private Figure f;
    private List<Move> whiteMoves = new ArrayList<>();
    private List<Move> blackMoves = new ArrayList<>();

    public Move(int x1, int y1, int x2, int y2, Figure f){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.f = f;
    }
    public List<Move> availableMoveList(int x1, int y1, int x2, int y2, Figure f){
        if (f.getColor() == "W"){
            if(f instanceof Pawn){


            } else if (f instanceof Queen){

            } else {
                return whiteMoves;
            }


        } else if(f.getColor() == "B"){

        } else {
            return whiteMoves;
        }

        return  whiteMoves;
    }
}

