package com.kodilla.sudoku;

public class SudokuGame {
    private SudokuBoard board = new SudokuBoard();

    public SudokuBoard getBoard() {
        return board;
    }

    public boolean resolveSudoku() {
        while (true) {
            System.out.println(board);
            Entry entry = UserDialogs.getEntry();

            switch (entry.getCmd()) {
                case UserDialogs.QUIT: return false;
                case UserDialogs.RESOLVE: board.resolveSudoku(board);
                    System.out.println(board);
                    return true;
                case UserDialogs.EXAMPLE: fillExampleData(board);
                    break;
                default: board.setValue(entry.getRow(), entry.getCol(), entry.getValue());
                    break;
            }
        }
    }

    void fillExampleData(SudokuBoard sudokuBoard) {

        sudokuBoard.setValue(3,0,2);
        sudokuBoard.setValue(8,0,3);
        sudokuBoard.setValue(1,1,7);
        sudokuBoard.setValue(4,1,9);
        sudokuBoard.setValue(6,1,2);
        sudokuBoard.setValue(1,2,6);
        sudokuBoard.setValue(2,2,1);
        sudokuBoard.setValue(3,2,5);
        sudokuBoard.setValue(4,2,8);
        sudokuBoard.setValue(7,2,4);
        sudokuBoard.setValue(8,2,9);
        sudokuBoard.setValue(0,3,8);
        sudokuBoard.setValue(5,3,4);
        sudokuBoard.setValue(8,3,1);
        sudokuBoard.setValue(0,5,7);
        sudokuBoard.setValue(3,5,8);
        sudokuBoard.setValue(8,5,4);
        sudokuBoard.setValue(0,6,5);
        sudokuBoard.setValue(1,6,9);
        sudokuBoard.setValue(4,6,7);
        sudokuBoard.setValue(5,6,8);
        sudokuBoard.setValue(6,6,3);
        sudokuBoard.setValue(7,6,1);
        sudokuBoard.setValue(2,7,4);
        sudokuBoard.setValue(4,7,3);
        sudokuBoard.setValue(7,7,5);
        sudokuBoard.setValue(0,8,6);
        sudokuBoard.setValue(5,8,1);
    }
}