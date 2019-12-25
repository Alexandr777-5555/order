package ru.register.shop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.register.shop.business.ExistsManage;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service("controller")
@Path("/sc")
public class ShopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    @Qualifier("manageService")
    private ExistsManage manage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public StoreAddressResponse findCertificateActive() { //StoreAddressRequest request
        LOGGER.info("findCertificateActive CALLED");
        return manage.findRegisterShop(null);
    }


    public void setManage(ExistsManage manage) {
        this.manage = manage;
    }
}
