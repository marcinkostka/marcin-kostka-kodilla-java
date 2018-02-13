package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("KODILLA Singleton 1");
        Logger.getInstance().log("KODILLA Singleton 2");

        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + lastLog);

        //Then
        Assert.assertEquals("KODILLA Singleton 2", lastLog);
    }
}
