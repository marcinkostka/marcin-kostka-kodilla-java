package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MentorTestSuite {

    @Test
    public void testUpdate() {
        //Given

        Student marcin = new Student("Marcin", "Kostka", "mail.@mail.com");
        Student piotr = new Student("Piotr", "Kowalski", "piotr@mail.com");
        TaskService marcinTasks = new TaskService( marcin);
        TaskService piotrTasks = new TaskService(piotr);

        Task task1 = new Task(20.4,"Wzorzec Obserwator");
        Task task2 = new Task(20.1,"Wzorzec Fasada");
        Task task3 = new Task(20.2,"Wzorzec Dekorator");

        Mentor andrzej = new Mentor("Andrzej");
        Mentor tomasz = new Mentor("Tomasz");

        marcinTasks.registerObserver(andrzej);
        piotrTasks.registerObserver(tomasz);
        piotrTasks.registerObserver(andrzej);

        //When
        marcinTasks.addTask(task1);
        piotrTasks.addTask(task2);
        piotrTasks.addTask(task3);

        //Then
        assertEquals(2,tomasz.getCount());
        assertEquals(3, andrzej.getCount());
    }
}
