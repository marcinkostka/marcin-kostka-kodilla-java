package com.kodilla.good.patterns.food2door;

import java.util.List;

public class GlutenFreeShop implements FoodProvider {
    private String falseResponse;

    @Override
    public String getName() {
        return "Gluten Free Shop";
    }

    @Override
    public void OrderFalseResponse() {
        System.out.println(falseResponse);
    }

    @Override
    public boolean process(FoodProvider foodProvider, List<Product> products2delivery) {
        int quantitySum = 0;
        int quantitySumMin = 5;
        Double priceSum = 0.0;
        Double priceSumMin = 20.0;

        for (Product product : products2delivery) {
            priceSum = priceSum + product.getPrice();
            quantitySum = quantitySum + product.getQuantity();
        }

        if (quantitySum > 3 && priceSum > 20.0) {
            return true;
        } else {
            falseResponse = "Product's quantity should be more than " +
            quantitySumMin + "pcs and total price of your order must be greater than " +
                    priceSumMin +"$. You ordered "+ quantitySum +
                    "pcs, and total price is " + priceSum + "$";
            return false;
        }
    }
}