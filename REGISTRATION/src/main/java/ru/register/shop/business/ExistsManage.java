package ru.register.shop.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.register.shop.dao.ExistsShopDAO;
import ru.register.shop.domain.RegisterCertificate;
import ru.register.shop.rest.ShopController;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

public class ExistsManage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsManage.class);

     private ExistsShopDAO shopDAO;


    /**
     *
     * найти что данный магазин существует
     *
     * @param request запрос
     * @return
     */
    public StoreAddressResponse findRegisterShop(StoreAddressRequest request){
        LOGGER.info("findRegisterShop CALLED");
        RegisterCertificate certificate = shopDAO.findCertificate(request);
        return new StoreAddressResponse();
    }


    public void setShopDAO(ExistsShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }
}
