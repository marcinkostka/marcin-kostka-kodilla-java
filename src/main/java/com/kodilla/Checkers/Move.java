package com.kodilla.Checkers;
import java.util.ArrayList;
import java.util.List;

public class Move {

    private int x1,x2,y1,y2;
    Figure f;
    Board board;

    private List<Move> movesList = new ArrayList<>();

    public Move(int x1, int y1, int x2, int y2, Board board){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.board = board;
    }

    public Move(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return x1 == move.x1 &&
                x2 == move.x2 &&
                y1 == move.y1 &&
                y2 == move.y2;
    }

    public static Move convertCoords(String coords){
        String col = "ABCDEFGH";
        String row = "12345678";
        int x1, x2, y1, y2;

        x1 = col.indexOf(coords.substring(0,1));
        y1 = row.indexOf(coords.substring(1,2));
        x2 = col.indexOf(coords.substring(2,3));
        y2 = row.indexOf(coords.substring(3,4));

        return new Move(x1, y1, x2, y2);
    }

    public List<Move> availableMoveList(){
// TODO: 2017-12-31 bicie piona, ruchy krolowa

        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                //w prawo bialymi
                if (movePossible(col, row, col+1, row+1)){
                    movesList.add(new Move(col, row, col+1, row+1, board));
                }
                //w lewo białymi
                if (movePossible(col, row, col-1, row+1)){
                    movesList.add(new Move(col, row, col-1, row+1, board));
                }
                //w prawo czarnymi
                if (movePossible(col, row, col+1, row-1)){
                    movesList.add(new Move(col, row, col+1, row-1, board));
                }
                //w lewo czarnymi
                if (movePossible(col, row, col-1, row-1)){
                    movesList.add(new Move(col, row, col-1, row-1, board));
                }
            }
        }
        return movesList;
    }

    private boolean movePossible(int x1, int y1, int x2, int y2){

        //czy ruchy w obrebie planszy

        if (board.getFigure(x1,y1) instanceof None){
            return false;
        }

        if( x1 < 0 || y1 < 0 || x2 > 7 || y2 > 7  || x2 < 0 || y2 < 0 || x1 > 7 || y1 > 7){
            return false;
        }
        //czy docelowe pole puste
        if(!(board.getFigure(x2,y2) instanceof None)){
            return false;
        }
        //czy tura białych - color przestawiamy w Board.move() po wykonaniu ruchu
        if (board.getColor() == "W"){
            if (board.getFigure(x1,y1).getColor() == "W" && y2 > y1){
                //białe poruszaja sie w dół index y2 musi byc wiekszy
                return true;
            } else {
                return false;
            }

        } else if (board.getColor() == "B") {
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

