package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(5);

        //When
        shapeCollector.addFigure(shape);

        //Then
        Assert.assertEquals("Square", shape.getShapeName());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(5);
        shapeCollector.addFigure(shape);

        //When
        boolean result = shapeCollector.removeFigure(shape);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(null, shapeCollector.getFigure(0));
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(5);
        shapeCollector.addFigure(shape);

        //When
        Shape result = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(shape, result);
    }

    @Test
    public void testShowFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(7);
        shapeCollector.addFigure(shape);

        //When
        String result = shapeCollector.showFigures();

        //Then
        Assert.assertEquals("Figure name: Square ,field: 49.0", result);
    }
}
