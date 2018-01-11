package com.kodilla.testing.shape;

class Triangle implements Shape {
    private double a,h;

    public Triangle (double a, double h){
        this.a = a;
        this.h = h;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public Double getField() {
        return 0.5*a*h;
    }

    @Override
    public String toString(){
        return "Figure name: "+getShapeName()+" ,field: "+getField();
    }
}