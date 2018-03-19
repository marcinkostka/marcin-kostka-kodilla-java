package com.kodilla.sudoku;

public class Entry {
    private int row;
    private int col;
    private int value;
    private String cmd;

    public Entry(int row, int col, int value, String cmd) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.cmd = cmd;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public String getCmd() {
        return cmd;
    }
}