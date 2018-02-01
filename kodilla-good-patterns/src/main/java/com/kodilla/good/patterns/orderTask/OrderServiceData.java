package com.kodilla.good.patterns.orderTask;

import java.util.List;

class OrderServiceData implements OrderService{
    @Override
    public boolean order(User user, List<Product> products) {
        System.out.println("Your order:");

        for(Product product : products){
            System.out.println(product.getName()+ " "+product.getQuantity()+
            " "+product.getQuantity()*product.getPrice());
        }
        return true;
    }
}
