package com.kodilla.patterns2.observer.homework;

public class Student {
    private String firstName;
    private String lasstName;
    private String email;

    public Student(String firstName, String lasstName, String email) {
        this.firstName = firstName;
        this.lasstName = lasstName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasstName() {
        return lasstName;
    }

    public String getEmail() {
        return email;
    }
}
