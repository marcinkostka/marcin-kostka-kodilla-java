package checkers;

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

    public static Move convertCoords(String coords, Board board){
        String col = "ABCDEFGH";
        String row = "12345678";
        int x1, x2, y1, y2;

        x1 = col.indexOf(coords.substring(0,1));
        y1 = row.indexOf(coords.substring(1,2));
        x2 = col.indexOf(coords.substring(2,3));
        y2 = row.indexOf(coords.substring(3,4));

        return new Move(x1, y1, x2, y2, board);
    }

    public List<Move> availableMoveList(){
// TODO: 2017-12-31 ruchy krolowa

        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                //jesli trwa bicie, i jest możliwość bicia - musimy bić
                if (board.getFigure(col,row) instanceof Pawn) {
                    if (!board.getContinueBeating()) {
                        //w prawo bialymi
                        if (movePossible(col, row, col + 1, row + 1)) {
                            movesList.add(new Move(col, row, col + 1, row + 1, board));
                        }
                        //w lewo białymi
                        if (movePossible(col, row, col - 1, row + 1)) {
                            movesList.add(new Move(col, row, col - 1, row + 1, board));
                        }
                        //w prawo czarnymi
                        if (movePossible(col, row, col + 1, row - 1)) {
                            movesList.add(new Move(col, row, col + 1, row - 1, board));
                        }
                        //w lewo czarnymi
                        if (movePossible(col, row, col - 1, row - 1)) {
                            movesList.add(new Move(col, row, col - 1, row - 1, board));
                        }
                    }
                    //############### Bicie #########################################
                    if (pawnBeating(col, row, col + 2, row + 2)) {
                        movesList.add(new Move(col, row, col + 2, row + 2, board));
                    }
                    if (pawnBeating(col, row, col - 2, row + 2)) {
                        movesList.add(new Move(col, row, col - 2, row + 2, board));
                    }
                    if (pawnBeating(col, row, col + 2, row - 2)) {
                        movesList.add(new Move(col, row, col + 2, row - 2, board));
                    }
                    if (pawnBeating(col, row, col - 2, row - 2)) {
                        movesList.add(new Move(col, row, col - 2, row - 2, board));
                    }
                }
                if (board.getFigure(col,row) instanceof Queen) {
                    queenMove(col,row);
                }
            }
        }
        return movesList;
    }

    public void queenMove(int x1, int y1) {

        int figOnLine = 0;
        boolean stopMove = false;
        //x1+1, y1+1; x1-1, y1-1; x1+1, y1-1; x1-1, y1+1
        for (int i = 1; i < 8; i++) {
            if (x1 + i < 8 && y1 + i < 8) {
                if (board.getFigure(x1 + i, y1 + i) instanceof None && !stopMove) {
                    movesList.add(new Move(x1, y1, x1 + i, y1 + i, board));
                }
                if (board.getFigure(x1 + i, y1 + i).getColor() == "B" && board.getColor() == "W" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 + i, y1 + i).getColor() == "W" && board.getColor() == "B" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 + i, y1 + i).getColor() == "W" && board.getColor() == "W" && !stopMove) {
                    stopMove = true;
                }
                if (board.getFigure(x1 + i, y1 + i).getColor() == "B" && board.getColor() == "B" && !stopMove) {
                    stopMove = true;
                }
            }
        }
        figOnLine = 0;
        stopMove = false;

        for (int i = 1; i < 8; i++) {
            if (x1 - i >= 0 && y1 - i >= 0) {
                if (board.getFigure(x1 - i, y1 - i) instanceof None && !stopMove) {
                    movesList.add(new Move(x1, y1, x1 - i, y1 - i, board));
                }
                if (board.getFigure(x1 - i, y1 - i).getColor() == "B" && board.getColor() == "W" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 - i, y1 - i).getColor() == "W" && board.getColor() == "B" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 - i, y1 - i).getColor() == "W" && board.getColor() == "W" && !stopMove) {
                    stopMove = true;
                }
                if (board.getFigure(x1 - i, y1 - i).getColor() == "B" && board.getColor() == "B" && !stopMove) {
                    stopMove = true;
                }
            }
        }

        figOnLine = 0;
        stopMove = false;

        for (int i = 1; i < 8; i++) {
            if (x1 + i < 8 && y1 - i >= 0) {
                if (board.getFigure(x1 + i, y1 - i) instanceof None && !stopMove) {
                    movesList.add(new Move(x1, y1, x1 + i, y1 - i, board));
                }
                if (board.getFigure(x1 + i, y1 - i).getColor() == "B" && board.getColor() == "W" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 + i, y1 - i).getColor() == "W" && board.getColor() == "B" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 + i, y1 - i).getColor() == "W" && board.getColor() == "W" && !stopMove) {
                    stopMove = true;
                }
                if (board.getFigure(x1 + i, y1 - i).getColor() == "B" && board.getColor() == "B" && !stopMove) {
                    stopMove = true;
                }
            }
        }

        figOnLine = 0;
        stopMove = false;

        for (int i = 1; i < 8; i++) {
            if (x1 - i >= 0 && y1 + i < 8) {
                if (board.getFigure(x1 - i, y1 + i) instanceof None && !stopMove) {
                    movesList.add(new Move(x1, y1, x1 - i, y1 + i, board));
                }
                if (board.getFigure(x1 - i, y1 + i).getColor() == "B" && board.getColor() == "W" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 - i, y1 + i).getColor() == "W" && board.getColor() == "B" && !stopMove) {
                    figOnLine++;
                    if (figOnLine == 2) {
                        stopMove = true;
                    }
                }
                if (board.getFigure(x1 - i, y1 + i).getColor() == "W" && board.getColor() == "W" && !stopMove) {
                    stopMove = true;
                }
                if (board.getFigure(x1 - i, y1 + i).getColor() == "B" && board.getColor() == "B" && !stopMove) {
                    stopMove = true;
                }
            }
        }
    }

    private boolean pawnBeating(int x1, int y1, int x2, int y2){
        if (movePossible(x1, y1, x2, y2)){
            //bicie w prawo białymi
            if (!(x2-1 < 0  || y2-1 < 0)) {
                if (board.getColor() == "W" && board.getFigure(x2 - 1, y2 - 1).getColor() == "B" && x2 > x1) {
                    board.setPawnBeating(true);
                    return true;
                }
            }
            //bicie w lewo białymi
            if (!(x2+1 > 7  || y2-1 < 0)) {
                if (board.getColor() == "W" && board.getFigure(x2 + 1, y2 - 1).getColor() == "B" && x2 < x1) {
                    board.setPawnBeating(true);
                    return true;
                }
            }
            //bicie w prawo czarnymi
            if (!(x2-1 < 0  || y2+1 > 7)) {
                if (board.getColor() == "B" && board.getFigure(x2 - 1, y2 + 1).getColor() == "W" && x2 > x1) {
                    board.setPawnBeating(true);
                    return true;
                }
            }
            //bicie w lewo czarnymi
            if (!(x2+1 > 7  || y2+1 > 7)) {
                if (board.getColor() == "B" && board.getFigure(x2 + 1, y2 + 1).getColor() == "W" && x2 < x1) {
                    board.setPawnBeating(true);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean movePossible(int x1, int y1, int x2, int y2){

        //czy ruszam figura
        if (board.getFigure(x1,y1) instanceof None){
            return false;
        }
        //czy ruchy w obrebie planszy
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