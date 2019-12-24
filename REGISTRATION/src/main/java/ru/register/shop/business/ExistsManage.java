package ru.register.shop.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.register.shop.dao.ExistsShopDAO;
import ru.register.shop.dao.ShopDao;
import ru.register.shop.domain.BigShop;
import ru.register.shop.domain.RegisterCertificate;
import ru.register.shop.domain.Shop;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

import java.time.LocalDate;

@Service("manageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ExistsManage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsManage.class);

    @Autowired
     private ExistsShopDAO shopDAO;

    @Autowired
     private ShopDao dao;

    /**
     *
     * найти что данный магазин существует
     *
     * @param request запрос
     * @return
     */
    @Transactional()
    public StoreAddressResponse findRegisterShop(StoreAddressRequest request){
        LOGGER.info("findRegisterShop CALLED");
        RegisterCertificate certificate = shopDAO.findCertificate(request);

        dao.findShops();

        dao.addShop(newShop());
        dao.addShop(newShop());
        dao.addShop(newShop());
        
        return new StoreAddressResponse();
    }

    private Shop newShop() {
        Shop shop=new BigShop();
        shop.setName("Гастроном");
        shop.setInn(125404);
        shop.setDateCreate(LocalDate.of(1999 , 10 , 13));
        return shop;
    }


}
