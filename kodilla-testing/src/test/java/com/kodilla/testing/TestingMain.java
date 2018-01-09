package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("\nTest - pierwszy test jednostkowy:");

        Calculator calc = new Calculator();
        int addResult = calc.add(7,6);
        int subResult = calc.subtract(10,6);

        if ( addResult == 13){
            System.out.println("Adding test OK");
        } else {
            System.out.println("Adding Error!");
        }

        if ( subResult == 4){
            System.out.println("Subtract test OK");
        } else {
            System.out.println("Subtract Error!");
        }

    }
}