package com.kodilla.good.patterns.food2door;

import java.util.List;

public class HealthyShop implements FoodProvider {
    private String falseResponse;

    @Override
    public String getName(){
        return "Healthy Shop";
    }

    @Override
    public void OrderFalseResponse() {
        System.out.println(falseResponse);
    }

    @Override
    public boolean process(FoodProvider foodProvider, List<Product> products2delivery) {
        Double priceSum = 0.0;
        Double priceSumMin = 50.0;

        for (Product product : products2delivery) {
            priceSum = priceSum + product.getPrice();
        }

        if (priceSum > 50.0) {
            return true;
        } else {
            falseResponse = "Total price of your order must be greater than " +
                    priceSumMin + ". Your order's total price is: " + priceSum + "$";
            return false;
        }
    }
}