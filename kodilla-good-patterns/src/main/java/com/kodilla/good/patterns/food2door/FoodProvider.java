package com.kodilla.good.patterns.food2door;

import java.util.List;

interface FoodProvider {
    boolean process(FoodProvider foodProvider, List<Product> products2delivery);
    String getName();
    void OrderFalseResponse();
}
