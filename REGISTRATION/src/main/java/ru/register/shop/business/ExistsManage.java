package ru.register.shop.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.register.shop.dao.ExistsShopDAO;
import ru.register.shop.domain.RegisterCertificate;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

@Service
public class ExistsManage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsManage.class);

    @Autowired
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

}
