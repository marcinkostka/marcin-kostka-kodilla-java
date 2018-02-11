package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getDoneList().addTask("Kodilla submodule 10.2");
        board.getInProgressList().addTask("Kodilla submodule 10.3");
        board.getToDoList().addTask("Kodilla submodule 10.4");

        //Then
        Assert.assertEquals("Kodilla submodule 10.2", board.getDoneList().getTasks().get(0));
        Assert.assertEquals("Kodilla submodule 10.3", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("Kodilla submodule 10.4", board.getToDoList().getTasks().get(0));
    }

    @Test
    public void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
