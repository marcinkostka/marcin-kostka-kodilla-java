package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderRequest {
    FoodProvider foodProvider;
    private List<Product> products2delivery;

    OrderRequest(FoodProvider foodProvider, List<Product> products2delivery) {
        this.foodProvider = foodProvider;
        this.products2delivery = products2delivery;
    }

    public FoodProvider getFoodProvider() {
        return foodProvider;
    }

    public List<Product> getProducts2delivery() {
        return products2delivery;
    }
}
