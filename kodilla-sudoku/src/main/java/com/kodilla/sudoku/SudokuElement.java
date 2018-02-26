package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = 0;

    private int value = EMPTY;
    private List<Integer> possibleValues= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value=" + value +
                ", possibleValues=" + possibleValues +
                '}';
    }
}
