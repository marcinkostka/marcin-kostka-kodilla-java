package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();
        Continent continent1 = new Continent("Europa");
        Continent continent2 = new Continent("Afryka");
        Continent continent3 = new Continent("Ameryka");
        Continent continent4 = new Continent("Azja");

        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);

        //When
        continent1.addCountry(new Country("Polska", new BigDecimal(39000000)));
        continent1.addCountry(new Country("Niemcy", new BigDecimal(80000000)));
        continent2.addCountry(new Country("Nigieria", new BigDecimal(40000000)));
        continent2.addCountry(new Country("Egipt", new BigDecimal(27000000)));
        continent3.addCountry(new Country("USA", new BigDecimal(180000000)));
        continent3.addCountry(new Country("Canada", new BigDecimal(80000000)));
        continent4.addCountry(new Country("Chiny", new BigDecimal(800000000)));
        continent4.addCountry(new Country("Indie", new BigDecimal(500000000)));

        //Then
        Assert.assertEquals(new BigDecimal(1746000000), world.getPeopleQuantity());
    }
}
