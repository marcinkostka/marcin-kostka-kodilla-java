package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("ShoppingTask", "tomato", 4.0);
            case PAINTING:
                return new PaintingTask("PaintingTask", "blue", "wall");
            case DRIVING:
                return new DrivingTask("DrivingTask", "Katowice", "car");
            default:
                return null;
        }
    }
}