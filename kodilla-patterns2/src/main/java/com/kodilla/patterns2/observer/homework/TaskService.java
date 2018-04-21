package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskService implements Observable{

    private final List<Observer> observers;
    private final Student student;
    private final List<Task> tasks;

    public TaskService(Student student) {
        this.student = student;
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }
    public Student getStudent() {
        return student;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

}
