package com.kodilla.good.patterns.food2door;

public class FoodProvider {
    private String name;
    private String address;

    public FoodProvider(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "FoodProvider{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
