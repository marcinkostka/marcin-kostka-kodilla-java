package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    List<SudokuRow> rowsList = new ArrayList<>(9);

    public void initBoard() {

        for (int row = 0; row < 9; row++) {
            SudokuRow sudokuRow = new SudokuRow();
            rowsList.add(sudokuRow);

            for (int col = 0; col < 9; col++) {
                SudokuElement sudokuElement = new SudokuElement();
                sudokuRow.elementsList.add(sudokuElement);
            }
        }
    }
/*
    public void printPossibleValues() {
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.println("value: "+rowsList.get(j).getElementsList().get(i).getValue()+
                        " i: "+i+",j: "+j+ " list: "+ rowsList.get(j).getElementsList().get(i).getPossibleValues());
            }
        }
    }
 */

    public void solveSudoku() {
        while (isOnlyOnePossibleValue()){

        }
    }

    private boolean isOnlyOnePossibleValue() {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (rowsList.get(row).getElementsList().get(col).getPossibleValues().size() == 1) {
                        setValue(col+1, row+1, rowsList.get(row).getElementsList().get(col).getPossibleValues().get(0));
                        return true;
                    }
                }
            }
        return false;
    }


    public void setValue (int x, int y, Integer value) {
        x = x-1;
        y = y-1;
        if(rowsList.get(y).getElementsList().get(x).getValue() == SudokuElement.EMPTY) {
            if (rowsList.get(y).getElementsList().get(x).getPossibleValues().contains(value)) {
                rowsList.get(y).getElementsList().get(x).setValue(value);
                rowsList.get(y).getElementsList().get(x).getPossibleValues().clear();

                //update possible values in every Elements in col
                for (int col = 0; col < 9; col++) {
                    if(rowsList.get(y).getElementsList().get(col).getPossibleValues().contains(value)){
                        rowsList.get(y).getElementsList().get(col).getPossibleValues().remove(value);
                    }
                }

                //update possible values in every Elements in row
                for (int row = 0; row < 9; row++) {
                    if(rowsList.get(row).getElementsList().get(x).getPossibleValues().contains(value)){
                        rowsList.get(row).getElementsList().get(x).getPossibleValues().remove(value);
                    }
                }

                //update possible values in every Elements in small Square 3x3
                for(int i=0; i<3; i++) {
                    for (int j=0; j<3;j++) {
                        if(rowsList.get((y/3)*3+j).getElementsList().get((x/3)*3+i).getPossibleValues().contains(value)){
                            rowsList.get((y/3)*3+j).getElementsList().get((x/3)*3+i).getPossibleValues().remove(value);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int col = 0; col < 9; col++) {
            result += "--";
        }
        result += "\n";
        for(int row = 0; row < 9; row++) {
            result += "|";
            for (int col = 0; col < 9; col++) {
                int sudokuElementValue = rowsList.get(row).getElementsList().get(col).getValue();
                result += sudokuElementValue + "|";
            }
            result += "\n";
        }

        for(int col = 0; col < 9; col++) {
            result += "--";
        }
        return result;
    }
}