package com.kodilla.good.patterns.food2door;

public class OrderDto {
    FoodProvider foodProvider;
    Boolean isOrder;

    public OrderDto(FoodProvider foodProvider, Boolean isOrder) {
        this.foodProvider = foodProvider;
        this.isOrder = isOrder;
    }

    public FoodProvider getFoodProvider() {
        return foodProvider;
    }

    public Boolean getOrder() {
        return isOrder;
    }
}
