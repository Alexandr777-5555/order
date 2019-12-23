package ru.register.shop.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.register.shop.dao.ExistsShopDAO;
import ru.register.shop.dao.ShopDao;
import ru.register.shop.domain.RegisterCertificate;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

@Service("manageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ExistsManage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsManage.class);

    @Autowired
     private ExistsShopDAO shopDAO;

   //  @Autowired
     private ShopDao dao;

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
