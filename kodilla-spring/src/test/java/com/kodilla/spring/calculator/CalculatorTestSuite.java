package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {
    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double sum = calculator.add(12,3);
        double difference = calculator.sub(12,3);
        double product = calculator.mul(12,3);
        double quotient = calculator.div(12,3);

        //Then
        Assert.assertEquals(15.0, sum, 1);
        Assert.assertEquals(9.0, difference, 1);
        Assert.assertEquals(36.0, product, 1);
        Assert.assertEquals(4.0, quotient, 1);
    }
}
