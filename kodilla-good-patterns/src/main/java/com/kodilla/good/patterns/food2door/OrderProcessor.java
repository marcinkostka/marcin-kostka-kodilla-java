package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderProcessor {
    private FoodProvider foodProvider;

    OrderProcessor(FoodProvider foodProvider) {
        this.foodProvider = foodProvider;
    }

    private void orderTrueResponse(FoodProvider foodProvider, List<Product> products2delivery) {
        System.out.println("Thanks for order in " +
                foodProvider.getName() + ". Your order:");

        for (Product product : products2delivery) {
            System.out.println(product.getName() + " " + product.getQuantity() +
                    " pcs " + product.getQuantity() * product.getPrice() + "$");
        }
    }

    public void process(final OrderRequest orderRequest) {
        boolean isOrderAccepted = foodProvider.process(orderRequest.getFoodProvider(),orderRequest.getProducts2delivery());

        if(isOrderAccepted) {
            orderTrueResponse(orderRequest.getFoodProvider(),orderRequest.getProducts2delivery());

        } else {
            System.out.println("Your order in " + orderRequest.foodProvider.getName() +
            " has been rejected.");
            orderRequest.getFoodProvider().OrderFalseResponse();
        }
    }
}