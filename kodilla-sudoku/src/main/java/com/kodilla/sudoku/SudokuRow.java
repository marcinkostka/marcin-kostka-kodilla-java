package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    List<SudokuElement> elementsList = new ArrayList<>(9);

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
