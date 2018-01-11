package com.kodilla.testing.collection;

import java.util.ArrayList;

class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenList = new ArrayList<>();

        for (Integer element : numbers) {
            if (element % 2 == 0) {
                evenList.add(element);
            }
        }
        return evenList;
    }
}
