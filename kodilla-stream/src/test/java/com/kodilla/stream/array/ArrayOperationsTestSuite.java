package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] arrayInt = {1,2,3,4,5};

        //When
        double result = ArrayOperations.getAverage(arrayInt);

        //Then
        Assert.assertEquals(3.0, result,1 );
    }
}
