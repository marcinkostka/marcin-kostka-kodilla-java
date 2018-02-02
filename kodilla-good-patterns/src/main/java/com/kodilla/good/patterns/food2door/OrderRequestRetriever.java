package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        Map<Product,Integer> productList = new HashMap<>();

        productList.put(new Product("Salatka warzywna", 15.0),2);
        productList.put(new Product("Koktajl owocowy", 10.0),1);
        productList.put(new Product("Bulki fit", 8.0),3);

        FoodProvider foodProvider = new FoodProvider("GoodFood","Katowice");

        return new OrderRequest(foodProvider, productList);
    }
}
