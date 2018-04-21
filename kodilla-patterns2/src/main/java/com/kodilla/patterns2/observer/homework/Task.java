package com.kodilla.patterns2.observer.homework;

public class Task {
    private double number;
    private String description;

    public Task(double number, String description) {
        this.number = number;
        this.description = description;
    }

    public double getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
