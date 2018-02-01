package com.kodilla.good.patterns.orderTask;

import java.util.List;

class OrderRepositoryData implements OrderRepository {
    @Override
    public void createOrder(User user, List<Product> products) {
        System.out.println("System Info: Adding order to database");
    }
}
