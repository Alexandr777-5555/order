package ru.register.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.register.shop.rest.ShopController;
import ru.register.shop.view.StoreAddressRequest;

public class Main {

    public static void main(String[] args) {

       ApplicationContext context = new ClassPathXmlApplicationContext(
               new String[]{"springContext.xml"}

       );

   //    ShopController controller = context.getBean("controller", ShopController.class);
    //    controller.findCertificateActive(new StoreAddressRequest());




    }
}
