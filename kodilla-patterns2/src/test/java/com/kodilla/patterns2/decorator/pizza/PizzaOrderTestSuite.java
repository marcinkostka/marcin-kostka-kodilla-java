package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testChickenGetCost() {
        // Given
        PizzaOrder theOrder = new PizzaBasicOrder();
        theOrder = new ChickenDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(17), calculatedCost);
    }

    @Test
    public void testChickenAndCornGetCost() {
        // Given
        PizzaOrder theOrder = new PizzaBasicOrder();
        theOrder = new ChickenDecorator(theOrder);
        theOrder = new CornDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(18), calculatedCost);
    }

    @Test
    public void testPizzaGetIngredients() {
        // Given
        PizzaOrder theOrder = new PizzaBasicOrder();
        theOrder = new ChickenDecorator(theOrder);
        theOrder = new CornDecorator(theOrder);
        // When
        List<String> ingredients = theOrder.getIngredients();
        System.out.println("Pizza dough with ingredients: " + ingredients.stream().collect(Collectors.joining(", ")));

        // Then
        assertEquals(4, ingredients.size());
        assertEquals("corn", ingredients.get(3));
    }
}
