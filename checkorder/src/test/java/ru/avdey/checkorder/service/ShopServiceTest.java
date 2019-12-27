package ru.avdey.checkorder.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.avdey.checkorder.rest.ShopController;
import ru.avdey.checkorder.view.ShopRequest;
import ru.avdey.checkorder.view.ShopResponse;

import java.util.List;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class ShopServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopServiceTest.class);

    @Autowired
    private ShopController controller;


    @Test
    public void simpleTest() {

        ShopRequest request = new ShopRequest();
        request.setName("магазин");
        request.setAddress("ленина");
        List<ShopResponse> list=controller.getShopInfo(request);
        Assert.assertTrue(list.size() >0);

    }
}


