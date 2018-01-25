package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import java.io.IOException;

public class ExceptionModuleRunner {

    public  static void main(String args[]) {

        /*FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong!" + e);
        } finally {
            System.out.println("I am gonna be here ... always!");
        }*/

        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem while reading file!");
        }

    }
}
