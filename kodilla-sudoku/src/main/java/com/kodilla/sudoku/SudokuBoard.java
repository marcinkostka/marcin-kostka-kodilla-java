package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> rowsList = new ArrayList<>();

    SudokuBoard() {
        for (int n=0; n<9; n++) {
            rowsList.add(new SudokuRow());
        }
    }

    public void setValue(int row,int col, int value) {
        rowsList.get(row).getElementsList().get(col).setValue(value);
    }

    public Integer getValue(int row, int col) {
        return rowsList.get(row).getElementsList().get(col).getValue();
    }

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {
        for (int row=0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if(sudokuBoard.getValue(row,col)!= SudokuElement.EMPTY) {
                    sudokuBoard.rowsList.get(row).getElementsList().get(col).getPossibleValues().clear();

                    //update possible values in every Elements in row
                    for (int col2 = 0; col2 < 9; col2++) {
                        if(sudokuBoard.rowsList.get(row).getElementsList().get(col2).getPossibleValues()
                                .contains(sudokuBoard.getValue(row,col))){
                            sudokuBoard.rowsList.get(row).getElementsList().get(col2).getPossibleValues()
                                    .remove(sudokuBoard.getValue(row,col));
                        }
                    }
                    //update possible values in every Elements in col
                    for (int row2 = 0; row2 < 9; row2++) {
                        if(sudokuBoard.rowsList.get(row2).getElementsList().get(col).getPossibleValues()
                                .contains(sudokuBoard.getValue(row,col))){
                            sudokuBoard.rowsList.get(row2).getElementsList().get(col).getPossibleValues()
                                    .remove(sudokuBoard.getValue(row,col));
                        }
                    }
                    //update possible values in every Elements in small Square 3x3
                    for(int i=0; i<3; i++) {
                        for (int j=0; j<3;j++) {
                            if(rowsList.get((row/3)*3+j).getElementsList().get((col/3)*3+i).getPossibleValues()
                                    .contains(sudokuBoard.getValue(row,col))){
                                rowsList.get((row/3)*3+j).getElementsList().get((col/3)*3+i).getPossibleValues()
                                        .remove(sudokuBoard.getValue(row,col));
                            }
                        }
                    }
                }
            }
        }
        //set value if element has one possibleValue
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard.rowsList.get(row).getElementsList().get(col).getPossibleValues().size() == 1) {
                    int value = sudokuBoard.rowsList.get(row).getElementsList().get(col).getPossibleValues().get(0);
                    sudokuBoard.setValue(row,col,value);
                    resolveSudoku(this);
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "-";
        for(int col = 0; col < 9; col++) {
            result += "----";
        }
        result += "\n";
        for(int row = 0; row < 9; row++) {
            result += "|";
            for (int col = 0; col < 9; col++) {
                int sudokuElementValue = rowsList.get(row).getElementsList().get(col).getValue();
                String s = sudokuElementValue != 0 ? "" + sudokuElementValue : " ";

                result += " " + s + " |";
            }
            result += "\n";
            result += "-";
            for(int col = 0; col < 9; col++) {
                result += "----";
            }
            result += "\n";
        }
        return result;
    }
}