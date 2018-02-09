package com.kodilla.spring.portfoilio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        System.out.println(tasks);
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }
}