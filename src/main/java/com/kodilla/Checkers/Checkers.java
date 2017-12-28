package com.kodilla.Checkers;

import java.util.*;
import java.lang.*;

class Figure {
    String color;

    public Figure(String color){
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}

class Pawn extends Figure{
    public Pawn(String color){
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
}

class Queen extends Figure{
    public Queen(String color){
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
}
class None extends Figure{
    public None(String color){
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
}

class BoardRow{
    Figure color;
    ArrayList<Figure> boardRow = new ArrayList<Figure>();
}
class Board{
}

public class Checkers {
    public static void main (String[] args) {

    }
}

