package com.kodilla.Checkers;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    List<Figure> figures = new ArrayList<Figure>();

    public BoardRow(){
        for (int i=0; i<8; i++){
            figures.add(new None());
        }
    }

    void setFigure(int index, Figure f){
        figures.remove(index);
        figures.add(index, f);
    }

    Figure getFigure(int index){
        return figures.get(index);
    }
}
