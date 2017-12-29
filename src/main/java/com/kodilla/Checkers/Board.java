package com.kodilla.Checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    String color = "W";

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

    void initBoard(Board board){
        board.setFigure(0,0, new Pawn("W"));
        board.setFigure(2,0, new Pawn("W"));
        board.setFigure(4,0, new Pawn("W"));
        board.setFigure(6,0, new Pawn("W"));
        board.setFigure(1,1, new Pawn("W"));
        board.setFigure(3,1, new Pawn("W"));
        board.setFigure(5,1, new Pawn("W"));
        board.setFigure(7,1, new Pawn("W"));
        board.setFigure(0,6, new Pawn("B"));
        board.setFigure(2,6, new Pawn("B"));
        board.setFigure(4,6, new Pawn("B"));
        board.setFigure(6,6, new Pawn("B"));
        board.setFigure(1,7, new Pawn("B"));
        board.setFigure(3,7, new Pawn("B"));
        board.setFigure(5,7, new Pawn("B"));
        board.setFigure(7,7, new Pawn("B"));
    }

    boolean isMoveAvailable(int x1, int y1, int x2, int y2){
        Figure figureStartPos = getFigure(x1,y1);
        Figure figureEndPos = getFigure(x2,y2);

        // TODO: 2017-12-29 zablokować ruchy do tyłu, wykonać transformacja na królową
        //czyja tura biały/czarny
        if(figureStartPos.getColor() != color){
            return false;
        } else {
            //ruch pionkiem
            if (figureStartPos instanceof Pawn)
            {
                //pole docelowe puste
                if (figureEndPos.getColor() == "N"){
                    if((Math.abs(x1-x2) == 1) && (Math.abs(y1-y2) == 1)){
                        return true;
                    //bicie
                    } else if((Math.abs(x1-x2) == 2) && (Math.abs(y1-y2) == 2) ){
                        if (x2 > x1){
                            if ((getFigure((x1+1),(y1+1)).getColor()!= "N") && (getFigure((x1+1),(y1+1)).getColor()!= figureStartPos.getColor())){
                                setFigure((x1+1),(y1+1), new None());
                                return true;
                            } else {
                                return false;
                            }
                        } else if (x1 > x2){
                            if ((getFigure((x1-1),(y1-1)).getColor()!= "N") && (getFigure((x1-1),(y1-1)).getColor()!= figureStartPos.getColor())){
                                setFigure((x1-1),(y1-1), new None());
                                return true;
                            } else {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                // TODO: 2017-12-29  ruch krolowa
            } else if (figureStartPos instanceof Queen){
                return false;
            } else {
                return false;
            }
        }
    }

    void move(int x1, int y1, int x2, int y2){

        if (isMoveAvailable(x1,y1,x2,y2)){
            Figure figure = getFigure(x1,y1);
            setFigure(x1, y1, new None());
            setFigure(x2, y2, figure);
            //nowa tura - zmiana wykonujacego ruch
            if (color == "W"){
                color = "B";
            } else {
                color = "W";
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
