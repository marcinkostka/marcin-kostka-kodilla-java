package com.kodilla.sudoku;

import java.util.Scanner;

public class UserDialogs {
    public static final String RESOLVE = "R";
    public static final String QUIT = "Q";
    public static final String VALUE = "V";
    public static final String EXAMPLE = "E";

    public static Entry getEntry() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter value XYV (X: 1-9, Y: 1-9, V: 1-9) or type" +
                    " R to resolve (Q: Quit) or E for Example");

            String s = scanner.nextLine().toUpperCase();

            if(s.equals(RESOLVE)) {
                return new Entry(0, 0, 0, RESOLVE);
            } else if (s.equals(EXAMPLE)) {
                return new Entry(0,0,0, EXAMPLE);
            } else if(s.equals(QUIT)){
                return new Entry(0,0,0, QUIT);
            } else {
                try {
                    if (s.length() > 3) {
                        throw new Exception();
                    }

                    int col = Integer.parseInt(s.substring(0,1))-1;
                    int row = Integer.parseInt(s.substring(1,2))-1;
                    int val = Integer.parseInt(s.substring(2,3));

                    if (col < 0 || row < 0 || val == 0){
                        throw new Exception();
                    }

                    return new Entry(row,col,val,VALUE);

                } catch (Exception e) {
                    System.out.println("Wrong data!");
                }
            }
        }
    }
}