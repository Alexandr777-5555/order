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
import ru.register.shop.domain.SmallShop;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

import java.time.LocalDate;
import java.util.List;

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
      //  RegisterCertificate certificate = shopDAO.findCertificate(request);

        dao.findShops();

        dao.addShop(newShop(1));
        dao.addShop(newShop(2));


        RegisterCertificate certificate = getCertificate();

        shopDAO.saveAndFlush(certificate);

        //shopDAO.findAll();

       //  shopDAO.findById(1L);


        List<RegisterCertificate> numbers = shopDAO.findByNumber("AA22RUSABVGD");
        numbers.forEach(num -> LOGGER.info("сертификат "  + num.getCertificateId()));


        List<RegisterCertificate> numberContaining = shopDAO.findByNumberContaining("A2");
        numberContaining.forEach(num -> LOGGER.info("сертификат подстрока "  + num.getCertificateId()));


        List<RegisterCertificate> numContaining = shopDAO.findByNum("AA22RUSABVGD");
        numContaining.forEach(num -> LOGGER.info("способ 2 :"  + num.getCertificateId()));


        List<RegisterCertificate> numb = shopDAO.findSome("EKLMN");
        numb.forEach(num -> LOGGER.info("способ 3 :"  + num.getCertificateId()));


        List<RegisterCertificate> certificates = shopDAO.findAll();
        for (RegisterCertificate registerCertificate:certificates){
            System.out.println(registerCertificate);
        }

        return new StoreAddressResponse();
    }


    private Shop newShop(int uid) {

        Shop shop= uid == 1 ? new SmallShop() : new BigShop();

        shop.setName("Гастроном");
        shop.setInn(125404);
        shop.setDateCreate(LocalDate.of(1999 , 10 , 13));
        return shop;
    }


    private RegisterCertificate getCertificate(){

        RegisterCertificate rc = new RegisterCertificate();
        rc.setNumber("EKLMN");
        rc.setIssueDate(LocalDate.now());
        rc.setActive(true);

        List<Shop> shops = dao.findShops();

        for (Shop shop: shops){

            if(shop instanceof BigShop){
                rc.setShop(shop);
            }
            if(shop instanceof SmallShop){
                rc.setShop(shop);
            }

        }

       return rc;
    }
}
