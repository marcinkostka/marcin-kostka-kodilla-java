package com.kodilla.good.patterns.orderTask;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("Kowalski", "kowalski@kodilla.pl");
        Product product1 = new Product("pomidor", 3, 2.0);
        Product product2 = new Product("sok", 2, 4.0);
        Product product3 = new Product("zabawka", 1, 25.0);

        List<Product> productList = new ArrayList<>();
        {
            productList.add(product1);
            productList.add(product2);
            productList.add(product3);
        }
        return new OrderRequest(user, productList);
    }
}
