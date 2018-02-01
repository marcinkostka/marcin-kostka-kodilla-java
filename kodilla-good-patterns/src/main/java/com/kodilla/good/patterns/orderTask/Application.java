package com.kodilla.good.patterns.orderTask;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        InformationServiceData informationServiceData = new InformationServiceData();
        OrderServiceData orderServiceData = new OrderServiceData();
        OrderRepositoryData orderRepositoryData = new OrderRepositoryData();

        OrderProcessor orderProcessor = new OrderProcessor(informationServiceData, orderServiceData, orderRepositoryData);
        orderProcessor.process(orderRequest);

    }
}
