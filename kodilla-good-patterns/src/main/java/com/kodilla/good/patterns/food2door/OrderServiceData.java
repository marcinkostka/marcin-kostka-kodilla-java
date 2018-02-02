package com.kodilla.good.patterns.food2door;

import java.util.Map;

class OrderServiceData implements OrderService {
    @Override
    public boolean order(FoodProvider foodProvider, Map<Product,Integer> products2delivery) {
        System.out.println("Your order:");

        for (Map.Entry<Product,Integer> entry : products2delivery.entrySet()){
            System.out.println(entry.getKey().getName()+" "+entry.getValue()+
                    " pcs "+entry.getKey().getPrice()*entry.getValue()+"$");
        }

        return true;
    }
}
