package com.kodilla.testing.shape;

class Square implements Shape {
    private double a;

    public Square (double a){
        this.a = a;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public Double getField(){
        return a*a;
    }

    @Override
    public String toString(){
        return "Figure name: "+getShapeName()+" ,field: "+getField();
    }
}