package area.main;

import area.dao.OrderFormImpl;
import area.domen.Shop;
import area.exception.DaoException;
import area.order.Order;
import area.product.Product;


import java.util.ArrayList;
import java.util.List;

public class MainOrder {

    public static void main(String[] args) throws DaoException {

        Shop shop=new Shop(1);

        Order order=new Order( 2, shop ,  10);

        Product product1=new Product(1 , 10 , "");
        Product product2=new Product(2 , 10, "");
        Product product3=new Product(3 , 10, "");

        List<Product> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        order.setProductList(productList);

        OrderFormImpl orderForm=new OrderFormImpl();

        orderForm.saveOrder(order);

        // распечатаем список заявок
        List<Order> orders=orderForm.getOrderList();

        for (Order order1: orders){
         //  System.out.println(order1.getProduct());   // TODO возникает ошибка
          System.out.println("это не важно" + order1.getProduct());

        }


    }
}
