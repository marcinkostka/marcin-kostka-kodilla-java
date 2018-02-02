package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface OrderService {
    boolean order(FoodProvider foodProvider, Map<Product, Integer> product2delivery);
}