package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SudokuTestSuite {

    @Test
    public void testFillExampleData() {
        //Given
        SudokuGame sudokuGame = new SudokuGame();
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        sudokuGame.fillExampleData(sudokuBoard);
        int value = sudokuBoard.getValue(8,0);
        System.out.println(sudokuBoard);

        //Then
        Assert.assertEquals(3,value);
    }

    @Test
    public void testPrintBoard() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        System.out.println(sudokuBoard);

        //Then
    }

    @Test
    public void testResolveSudokuCheckValuesInAllRowAndCol() {
        //Given
        SudokuGame sudokuGame = new SudokuGame();
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuGame.fillExampleData(sudokuBoard);
        sudokuBoard.resolveSudoku(sudokuBoard);

        //When
        Set<Integer> rowValues = new HashSet<>();
        Set<Integer> colValues = new HashSet<>();

        int rowSum = 0;
        int colSum = 0;
        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++) {
                rowValues.add(sudokuBoard.getValue(i, j));
                colValues.add(sudokuBoard.getValue(j, i));

                if (rowValues.size() == 9) {
                    rowSum++;
                }
                if (colValues.size() == 9) {
                    colSum++;
                }
            }
            rowValues.clear();
            colValues.clear();
        }

        //Then
        Assert.assertEquals(9,rowSum);
        Assert.assertEquals(9,colSum);
    }

    @Test
    public void testResolveSudokuCheckValuesInSmallSquare() {
        //Given
        SudokuGame sudokuGame = new SudokuGame();
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuGame.fillExampleData(sudokuBoard);
        sudokuBoard.resolveSudoku(sudokuBoard);

        //When
        Set<Integer> values = new HashSet<>();

        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++) {
                values.add(sudokuBoard.getValue(i, j));
            }
        }

        //Then
        Assert.assertEquals(9,values.size());
    }

    @Test
    public void testSetValueAndGetValue() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        sudokuBoard.setValue(1,2,6);
        int value = sudokuBoard.getValue(1,2);

        //Then
        Assert.assertEquals(6,value);
    }
}