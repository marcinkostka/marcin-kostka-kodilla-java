package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Ala ma kota", (txt -> "ABC " + txt + " ABC"));
        poemBeautifier.beautify("Ala ma kota", (txt -> txt.toUpperCase()));
        poemBeautifier.beautify("Ala ma kota", (txt -> txt.replace('a', '@').replace('A', '@')));
        poemBeautifier.beautify("Ala ma kota", (txt -> {

            String s = "";
            for (int n = 0; n < txt.length(); n++) {
                s = s + txt.substring(n, n + 1) + " ";
            }
            return s;
        }));


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}