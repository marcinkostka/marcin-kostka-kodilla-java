package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;

import com.kodilla.hibernate.invoice.dao.ItemDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Box");
        Product product2 = new Product("Bike");
        Product product3 = new Product("Bulb");


        Item item1 = new Item(product1, new BigDecimal(20), 5, new BigDecimal(100));
        Item item2 = new Item(product1, new BigDecimal(20), 1, new BigDecimal(20));
        Item item3 = new Item(product2, new BigDecimal(1000), 1, new BigDecimal(1000));
        Item item4 = new Item(product3, new BigDecimal(5), 3, new BigDecimal(15));

        Invoice invoice = new Invoice("03/03/2018/KODILLA");

        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item3);
        product3.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        invoiceDao.save(invoice);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);

        String invoiceNumber = invoice.getNumber();
        long productQuantity = productDao.count();
        long itemQuantity = itemDao.count();
        long invoiceQuantity = invoiceDao.count();

        //Then
        Assert.assertEquals("03/03/2018/KODILLA", invoiceNumber);
        Assert.assertEquals(3, productQuantity);
        Assert.assertEquals(4, itemQuantity);
        Assert.assertEquals(1, invoiceQuantity);

        //CleanUp
        try {
            itemDao.deleteAll();
            invoiceDao.deleteAll();
            productDao.deleteAll();

        } catch (Exception e) {
            //do nothing
        }
    }
}