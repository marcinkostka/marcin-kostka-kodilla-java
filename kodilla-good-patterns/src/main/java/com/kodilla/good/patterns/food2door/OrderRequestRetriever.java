package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {
    public OrderRequest retrieve(FoodProvider foodProvider) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Salatka warzywna", 5.0,1));
        productList.add(new Product("Koktajl owocowy", 15.0,1));
        productList.add(new Product("Bulki fit", 8.0,1));

        if (foodProvider instanceof ExtraFoodShop) {
            foodProvider = new ExtraFoodShop();
        }
        else if (foodProvider instanceof GlutenFreeShop) {
            foodProvider = new GlutenFreeShop();
        } else {
            foodProvider = new HealthyShop();
        }

        return new OrderRequest(foodProvider, productList);
    }
}
