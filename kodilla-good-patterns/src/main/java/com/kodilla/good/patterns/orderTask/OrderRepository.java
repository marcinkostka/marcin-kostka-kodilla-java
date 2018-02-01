package com.kodilla.good.patterns.orderTask;

import java.util.List;

public interface OrderRepository {
    void createOrder(User user, List<Product> products);
}
