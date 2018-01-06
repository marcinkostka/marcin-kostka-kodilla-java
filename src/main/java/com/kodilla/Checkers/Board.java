package com.kodilla.Checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    public String color = "W";
    public boolean pawnBeating = false;
    public boolean continueBeating = false;

    public Board(){
        for (int i=0; i<8; i++){
            rows.add(new BoardRow());
        }
    }

    public String getColor() {
        return color;
    }

    public Figure getFigure(int x, int y){
        return rows.get(y).getFigure(x);
    }

    public boolean getContinueBeating() {
        return continueBeating;
    }

    public void setFigure(int x, int y, Figure f){
        rows.get(y).setFigure(x,f);
    }

    public void setPawnBeating(boolean pawnBeating) {
        this.pawnBeating = pawnBeating;
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

    void initBoard2(Board board){
        board.setFigure(4, 1, new Pawn("W"));
        board.setFigure(1, 1, new Pawn("W"));
        board.setFigure(3, 2, new Pawn("B"));
        board.setFigure(5, 2, new Pawn("B"));
        board.setFigure(3, 4, new Pawn("B"));
        board.setFigure(3, 6, new Pawn("B"));
        board.setFigure(5, 6, new Pawn("B"));
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

            // zamiana na królową
            if(color == "W" && figure instanceof Pawn && y2==7){
                setFigure(x2, y2, new Queen("W"));
            } else if (color == "B" && figure instanceof Pawn && y2==0){
                setFigure(x2, y2, new Queen("B"));
            } else {
                setFigure(x2, y2, figure);
            }

            if(Math.abs(x2-x1) == 2 && Math.abs(y2-y1) == 2) {
                //bicie białymi
                if (pawnBeating && color == "W") {
                    if (x2 < x1) {
                        setFigure(x1 - 1, y1 + 1, new None());
                        pawnBeating = false;
                        continueBeating = true;
                    }
                    if (x2 > x1) {
                        setFigure(x1 + 1, y1 + 1, new None());
                        pawnBeating = false;
                        continueBeating = true;
                    }

                    //sprawdzenie czy w danej turze istnieje kolejne bicie
                    if (continueBeating) {
                        if (isMoveAvailable(x2, y2, x2 - 2, y2 + 2)) {
                            continueBeating = true;
                        } else if (isMoveAvailable(x2, y2, x2 + 2, y2 + 2)) {
                            continueBeating = true;
                        } else {
                            continueBeating = false;
                        }
                    }
                }
                // bicie czarnymi
                if (pawnBeating && color == "B") {
                    if (x2 < x1) {
                        setFigure(x1 - 1, y1 - 1, new None());
                        pawnBeating = false;
                        continueBeating = true;
                    }
                    if (x2 > x1) {
                        setFigure(x1 + 1, y1 - 1, new None());
                        pawnBeating = false;
                        continueBeating = true;
                    }
                    //sprawdzenie czy w danej turze istnieje kolejne bicie
                    if (continueBeating) {
                        if (isMoveAvailable(x2, y2, x2 - 2, y2 - 2)) {
                            continueBeating = true;
                        } else if (isMoveAvailable(x2, y2, x2 + 2, y2 - 2)) {
                            continueBeating = true;
                        } else {
                            continueBeating = false;
                        }
                    }
                }
            }

            System.out.println(this);
            //nowa tura - zmiana wykonujacego ruch jeśli nie jestesmy w trakcie bicia
            if (color == "W" && !continueBeating){
                System.out.println("Move: black.\nType coords in format A1B2 to move or Q to quit");
                color = "B";
            } else if (color == "W" && continueBeating){
                System.out.println("Move: white - continue beating.\nType coords in format A1B2 to move or Q to quit");
            } else if (color == "B" && !continueBeating){
                color = "W";
                System.out.println("Move: white.\nType coords in format A1B2 to move or Q to quit");
            } else if(color == "B" && continueBeating){
                System.out.println("Move: black - continue beating.\nType coords in format A1B2 to move or Q to quit");
            } else {
                System.out.println(this);
                System.out.println("Move is not available\n");
            }
        } else {
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
