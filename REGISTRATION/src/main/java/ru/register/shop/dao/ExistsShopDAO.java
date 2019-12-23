package ru.register.shop.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.register.shop.domain.RegisterCertificate;
import ru.register.shop.view.StoreAddressRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * существует ли такой магазин запрос в бд
 */
@Component
public class ExistsShopDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsShopDAO.class);

    private EntityManager entityManager;

    @Value("${test.value}")
    private String test;


    /*
    public ExistsShopDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }*/



    public RegisterCertificate findCertificate(StoreAddressRequest request) {
        LOGGER.info("findCertificate : " + test);
        //TODO изменю далее
        return null;
    }


    public void setTest(String test) {
        this.test = test;
    }


}
