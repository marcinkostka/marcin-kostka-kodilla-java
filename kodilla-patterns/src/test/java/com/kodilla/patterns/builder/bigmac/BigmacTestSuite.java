package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = null;

        try {
            bigmac = new Bigmac.BigmacBuilder()
                    .roll("sezam")
                    .burgers(2)
                    .ingredient("chili")
                    .ingredient("cheese")
                    .ingredient("onion")
                    .sauce("barbecue")
                    .build();
            System.out.println(bigmac);
        } catch (BigmacException e) {
            System.out.println("Error: "+e);
        }

        //When
        int burgersQuantity = bigmac.getBurgers();
        String rollChosen = bigmac.getRoll();
        String sauceChosen = bigmac.getSauce();
        int ingredientsQuantity = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(2,burgersQuantity);
        Assert.assertEquals("sezam",rollChosen);
        Assert.assertEquals("barbecue",sauceChosen);
        Assert.assertEquals(3,ingredientsQuantity);
    }

    @Test(expected = BigmacException.class)
    public void testBigmacExceptions() throws BigmacException {
        //Given
          Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .roll("sezam")
                    //.burgers(2)
                    .ingredient("chili")
                    .ingredient("cheese")
                    .ingredient("onion")
                    .sauce("barbecue")
                    .build();
            System.out.println(bigmac);
    }
}