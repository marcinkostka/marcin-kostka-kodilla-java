package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface DeliveryProcessSupport {
    void process(FoodProvider foodProvider, Map<Product,Integer> product2delivery);
}
