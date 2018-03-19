package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    List<SudokuElement> elementsList = new ArrayList<>();

    public SudokuRow() {
        for(int n=0; n<9; n++) {
            elementsList.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getElementsList() {
        return elementsList;
    }

    public void addElement(SudokuElement sudokuElement) {
        elementsList.add(sudokuElement);
    }

    @Override
    public String toString() {
        return "SudokuRow{" +
                "elementsList=" + elementsList +
                '}';
    }
}
