package com.kodilla;

public class Calculator {

    public double addAToB(double a, double b) {
        System.out.print(a+" + "+b+" = ");
        return a + b;
    }

    public double subAFromB(double a, double b) {
        System.out.print(a+" - "+b+" = ");
        return a - b;
    }
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println(calculator.addAToB(3, 5));
        System.out.println(calculator.subAFromB(11.7, 5.34));
    }
}
