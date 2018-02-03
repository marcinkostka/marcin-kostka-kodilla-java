package com.kodilla.good.patterns.food2door;

import java.util.List;

public class ExtraFoodShop implements FoodProvider {
    private String falseResponse;

    @Override
    public String getName() {
        return "Extra Food Shop";
    }

    @Override
    public void OrderFalseResponse() {
        System.out.println(falseResponse);
    }

    @Override
    public boolean process(FoodProvider foodProvider, List<Product> products2delivery) {
        int quantitySum = 0;
        int quantitySumMin = 5;

        for (Product product : products2delivery) {
            quantitySum = quantitySum + product.getQuantity();
        }

        if (quantitySum > 5) {
            return true;
        } else {
            falseResponse = "Product's quantity should be more than " +
                    quantitySumMin + "pcs. You ordered "+ quantitySum + "pcs";
            return false;
        }
    }
}