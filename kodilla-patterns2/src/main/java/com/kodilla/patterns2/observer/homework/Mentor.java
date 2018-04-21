package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{
    private final String mentorName;
    private int updateCount;

    public Mentor(String name) {
        this.mentorName = name;
    }

    @Override
    public void update(TaskService taskService) {
        System.out.println(mentorName + ": New task in queue from " + taskService.getStudent().getFirstName()
                + " " + taskService.getStudent().getLasstName() + "\n" + " (total: " + taskService.getTasks().size() + " tasks)");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getCount() {
        return updateCount;
    }
}
