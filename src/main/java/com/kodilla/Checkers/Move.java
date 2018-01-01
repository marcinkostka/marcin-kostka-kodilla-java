package com.kodilla.Checkers;
import java.util.ArrayList;
import java.util.List;

public class Move {

    private int x1,x2,y1,y2;
    Figure f;
    Board board;
    String color;

    private List<Move> movesList = new ArrayList<>();

    public Move(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    //do testów
    public Move(){
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public boolean equals(Object o){
        Move m = (Move) o;
        if (m.getX1() == x1 && m.getX2() == x2 && m.getY1() == y1 && m.getY2() == y2){
            return true;
        } else {
            return false;
        }
    }

    public List<Move> availableMoveList(){
// TODO: 2017-12-31 bicie piona, ruchy krolowa

        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                //w prawo bialymi
                if (movePossible(col, row, col+1, row+1)){
                    movesList.add(new Move(col, row, col+1, row+1));
                }
                //w lewo białymi
                if (movePossible(col, row, col-1, row+1)){
                    movesList.add(new Move(col, row, col-1, row+1));
                }
                //w prawo czarnymi
                if (movePossible(col, row, col+1, row-1)){
                    movesList.add(new Move(col, row, col-1, row+1));
                }
                //w lewo czarnymi
                if (movePossible(col, row, col-1, row-1)){
                    movesList.add(new Move(col, row, col-1, row+1));
                }
            }
        }
        return movesList;
    }

    private boolean movePossible(int x1, int y1, int x2, int y2){

        //czy ruchy w obrebie planszy
        if( x1 < 0 || y1 < 0 || x2 > 7 || y2 > 7 ){
            return false;
        }
        //czy docelowe pole puste
        if(board.getFigure(x2,y2).getColor() != "N"){
            return false;
        }
        //czy tura białych - color przestawiamy w Board.move() po wykonaniu ruchu
        if (color == "W"){
            if (board.getFigure(x1,y1).getColor() == "W" && y2 > y1){
                //białe poruszaja sie w dół index y2 musi byc wiekszy
                return true;
            } else {
                return false;
            }

        } else if (color == "B") {
            if (board.getFigure(x1,y1).getColor() == "B" && y2 < y1){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}

