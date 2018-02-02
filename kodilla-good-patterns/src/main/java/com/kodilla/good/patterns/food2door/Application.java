package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        DeliveryProcessSupport deliveryProcessSupport = new DeliveryProcessSupportSample1();
        OrderServiceData orderServiceData = new OrderServiceData();

/*
        OrderRepositoryData orderRepositoryData = new OrderRepositoryData();
*/
        OrderProcessor orderProcessor = new OrderProcessor(deliveryProcessSupport, orderServiceData);
        orderProcessor.process(orderRequest);


    }
}
