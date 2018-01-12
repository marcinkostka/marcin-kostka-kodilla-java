package com.kodilla.testing.shape;

import java.util.ArrayList;

class ShapeCollector {

    private ArrayList<Shape> figureList = new ArrayList<>();

    public void addFigure(Shape shape) {
        figureList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figureList.contains(shape)){
            figureList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < figureList.size()) {
            return figureList.get(n);
        } else {
            return null;
        }
    }

    public void showFigures() {
        for (Shape figure: figureList) {
            System.out.println("Figure name: " + figure.getShapeName() + " ,field: " + figure.getField());
        }
    }
}