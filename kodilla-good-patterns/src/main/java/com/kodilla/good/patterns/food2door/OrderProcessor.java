package com.kodilla.good.patterns.food2door;

public class OrderProcessor {
    private DeliveryProcessSupport deliveryProcessSupport;
    private OrderService orderService;

    public OrderProcessor(DeliveryProcessSupport deliveryProcessSupport, OrderService orderService) {
        this.deliveryProcessSupport = deliveryProcessSupport;
        this.orderService = orderService;
    }


    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrder = orderService.order(orderRequest.getFoodProvider(), orderRequest.getProducts2delivery());

        if(isOrder) {
            deliveryProcessSupport.process(orderRequest.foodProvider,orderRequest.getProducts2delivery());
            //orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProducts());
            return new OrderDto(orderRequest.getFoodProvider(), true);
        } else {
            return new OrderDto(orderRequest.getFoodProvider(), false);
        }
    }

}
