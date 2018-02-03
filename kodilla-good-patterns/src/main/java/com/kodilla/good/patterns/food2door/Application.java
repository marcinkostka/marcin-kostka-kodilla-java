package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve(new GlutenFreeShop());

        OrderProcessor orderProcessor = new OrderProcessor(orderRequest.foodProvider);
        orderProcessor.process(orderRequest);
    }
}
