package area.dao;

import area.domen.Shop;
import area.exception.DaoException;
import area.order.Order;

import area.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * тестируем функциональность класса {@link OrderFormImpl}
 */

public class OrderFormImplTest {



    @BeforeClass
    public static void startup() throws Exception {

        DBInit.startUpClean();
    }



    @Test
    public void testSaveOrderSuccess() throws DaoException {

        Shop shop = new Shop(1);

        Order order = new Order(2, shop, 10);

        Product product1 = new Product(1 , 13 , "");
        Product product2 = new Product(2, 13 , "");
        Product product3 = new Product(3, 13, "");

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        order.setProductList(productList);
        OrderFormImpl orderForm = new OrderFormImpl();
        orderForm.saveOrder(order);

        List<Order> orderList = orderForm.getOrderList();
        Assert.assertTrue(orderList.size()==1);

    }

    @Test(expected = NullPointerException.class) // тест ожидает конкретную ошибку
    public void testSaveOrderError() throws DaoException {
        Shop shop = new Shop(1);

        Order order = new Order(1, null, 10);

        Product product1 = new Product(1 , 13 , "");
        Product product2 = new Product(2, 13 , "");
        Product product3 = new Product(3, 13 , "");

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        order.setProductList(productList);
        OrderFormImpl orderForm = new OrderFormImpl();
        orderForm.saveOrder(order);




    }




}