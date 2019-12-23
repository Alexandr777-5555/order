package ru.register.shop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.register.shop.business.ExistsManage;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

@Service("controller")
public class ShopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ExistsManage manage;


    public StoreAddressResponse findCertificateActive(StoreAddressRequest request) {

        LOGGER.info("findCertificateActive CALLED");

        return manage.findRegisterShop(request);
    }


    public void setManage(ExistsManage manage) {
        this.manage = manage;
    }
}
