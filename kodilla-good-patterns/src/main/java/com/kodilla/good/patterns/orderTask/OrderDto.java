package com.kodilla.good.patterns.orderTask;

public class OrderDto {
    public User user;
    public boolean isOrder;

    public OrderDto(User user, boolean isOrder) {
        this.user = user;
        this.isOrder = isOrder;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrder() {
        return isOrder;
    }
}
