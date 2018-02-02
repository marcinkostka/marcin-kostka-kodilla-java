package com.kodilla.good.patterns.food2door;

import java.util.Map;

class DeliveryProcessSupportSample1 implements DeliveryProcessSupport {
    @Override
    public void process(FoodProvider foodProvider, Map<Product, Integer> product2delivery){
        System.out.println("Do something");
    }

}
