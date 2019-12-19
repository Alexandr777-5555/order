package ru.register.shop.dao;

import org.junit.Test;
import ru.register.shop.domain.Shop;

import java.util.List;

import static org.junit.Assert.*;


/**
 * тестируем функицинальность класса {@link ShopDao}
 */
public class ShopDaoTest {

    @Test
    public void testFindShopsSuccess() {

        ShopDao dao = new ShopDao();
        List<Shop> shops = dao.findShops();
        shops.forEach(shop -> {
            System.out.println(shop.getName());

            System.out.println("класс"  + shop.getClass().getName());
            System.out.println("адрес" + shop.getAddressList().size());
        });


    }


}