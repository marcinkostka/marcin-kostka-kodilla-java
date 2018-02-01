package com.kodilla.good.patterns.orderTask;

import java.util.List;

public interface OrderService {
    boolean order(User user, List<Product> products);
}
