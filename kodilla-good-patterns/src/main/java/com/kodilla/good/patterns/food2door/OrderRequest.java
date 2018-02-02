package com.kodilla.good.patterns.food2door;

import java.util.Map;

public class OrderRequest {
    FoodProvider foodProvider;
    Map<Product,Integer> products2delivery;

    public OrderRequest(FoodProvider foodProvider, Map<Product, Integer> products2delivery) {
        this.foodProvider = foodProvider;
        this.products2delivery = products2delivery;
    }

    public FoodProvider getFoodProvider() {
        return foodProvider;
    }

    public Map<Product, Integer> getProducts2delivery() {
        return products2delivery;
    }
}
