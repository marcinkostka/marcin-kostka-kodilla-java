package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator object = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<>();
        //When
        ArrayList<Integer> result =  object.exterminate(numbers);
        //Then
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator object = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();

        for (int i=1; i<10; i++){
            numbers.add(rnd.nextInt(100));
        }
        //When
        ArrayList<Integer> result =  object.exterminate(numbers);
        //Then
        for(Integer list: result){
            Assert.assertEquals(0, list % 2);
        }


    }
}