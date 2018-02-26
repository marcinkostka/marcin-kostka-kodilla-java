package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuTestSuite {

    @Test
    public void testPrintBoard() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initBoard();

        sudokuBoard.setValue(4,1,2);
        sudokuBoard.setValue(9,1,3);
        sudokuBoard.setValue(2,2,7);
        sudokuBoard.setValue(5,2,9);
        sudokuBoard.setValue(7,2,2);
        sudokuBoard.setValue(2,3,6);
        sudokuBoard.setValue(3,3,1);
        sudokuBoard.setValue(4,3,5);
        sudokuBoard.setValue(5,3,8);
        sudokuBoard.setValue(8,3,4);
        sudokuBoard.setValue(9,3,9);
        sudokuBoard.setValue(1,4,8);
        sudokuBoard.setValue(6,4,4);
        sudokuBoard.setValue(9,4,1);
        sudokuBoard.setValue(1,6,7);
        sudokuBoard.setValue(4,6,8);
        sudokuBoard.setValue(9,6,4);
        sudokuBoard.setValue(1,7,5);
        sudokuBoard.setValue(2,7,9);
        sudokuBoard.setValue(5,7,7);
        sudokuBoard.setValue(6,7,8);
        sudokuBoard.setValue(7,7,3);
        sudokuBoard.setValue(8,7,1);
        sudokuBoard.setValue(3,8,4);
        sudokuBoard.setValue(5,8,3);
        sudokuBoard.setValue(8,8,5);
        sudokuBoard.setValue(1,9,6);
        sudokuBoard.setValue(6,9,1);

        //When

        System.out.println(sudokuBoard);
        sudokuBoard.solveSudoku();
        System.out.println(sudokuBoard);

        /*
        for(int i=3; i<6; i++) {
            for (int j=0; j<3; j++) {
                System.out.println("value: "+sudokuBoard.rowsList.get(j).getElementsList().get(i).getValue()+
                        " i: "+(i+1)+",j: "+(j+1)+ " list: "+ sudokuBoard.rowsList.get(j).getElementsList().get(i).getPossibleValues());
            }
        }
        */

        //System.out.println(sudokuBoard.rowsList.get(0).getElementsList().get(2).getPossibleValues());

        //Then

    }
}
