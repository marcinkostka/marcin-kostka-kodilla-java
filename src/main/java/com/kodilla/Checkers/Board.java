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
        rows.remove(y);
        rows.add(y,setFigure(x,f););
    }
}
