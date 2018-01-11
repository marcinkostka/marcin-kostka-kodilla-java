package com.kodilla.testing.shape;

class Circle implements Shape {
    private double r;

    public Circle (double r){
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public Double getField(){
        return Math.PI*r*r;
    }

    @Override
    public String toString(){
        return "Figure name: "+getShapeName()+" ,field: "+getField();
    }
}