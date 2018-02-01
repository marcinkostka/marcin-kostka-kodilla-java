package com.kodilla.good.patterns.orderTask;

import java.util.List;

public class OrderRequest {
    private User user;
    private List<Product> products;

    public OrderRequest(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }
}
