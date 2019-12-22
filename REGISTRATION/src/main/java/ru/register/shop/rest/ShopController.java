package ru.register.shop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.register.shop.business.ExistsManage;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

public class ShopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

    private ExistsManage manage;


    public StoreAddressResponse findCertificateActive(StoreAddressRequest request) {

        LOGGER.info("findCertificateActive CALLED");

        return manage.findRegisterShop(request);
    }


    public void setManage(ExistsManage manage) {
        this.manage = manage;
    }
}
