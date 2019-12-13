package ru.avdey.dao;

import org.junit.Assert;
import org.junit.Test;
import ru.avdey.domain.ProductRequest;
import ru.avdey.domain.ProductResponse;
import ru.avdey.exception.ProductCheckException;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CheckOrderDaoTest {


    /**
     * есть ли такой продукт и количество его!!!
     *
     * @throws ProductCheckException
     */
    @Test
    public void checkProduct() throws ProductCheckException {

        ProductRequest request = new ProductRequest();

        request.setProduct_id(1);
        request.setTitle("молоко");
        request.setProductCount(76);
        request.setPrice(25.08);
        request.setDate(LocalDate.of(2012, 05, 15));

        CheckOrderDao checkOrderDao = new CheckOrderDao();

        checkOrderDao.setConnectionBuilder(new DirectConnectionBuilder());

        ProductResponse response = checkOrderDao.checkProduct(request);
        System.out.println(response.isExist());
        Assert.assertTrue(response.isExist());
        Assert.assertEquals(77, response.getCount());

        // Assert.assertTrue(1 );


    }

    @Test
    public void checkNameProduct() throws ProductCheckException {

        ProductRequest request = new ProductRequest();

        request.setProduct_id(1);
        request.setTitle("молоко");
        request.setProductCount(76);
        request.setPrice(25.08);
        request.setDate(LocalDate.of(2012, 05, 15));

        CheckOrderDao checkOrderDao = new CheckOrderDao();

        checkOrderDao.setConnectionBuilder(new DirectConnectionBuilder());

        ProductResponse response = checkOrderDao.checkProductForName(request);
        System.out.println(response.isExist());
        Assert.assertTrue(response.isExist());
      //  Assert.assertEquals(77, response.getCount());

        // Assert.assertTrue(1 );


    }


}