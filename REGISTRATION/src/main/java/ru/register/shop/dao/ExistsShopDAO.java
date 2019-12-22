package ru.register.shop.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.register.shop.domain.RegisterCertificate;
import ru.register.shop.rest.ShopController;
import ru.register.shop.view.StoreAddressRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * существует ли такой магазин запрос в бд
 *
 *
 */

public class ExistsShopDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsShopDAO.class);

    private EntityManager entityManager;


    public ExistsShopDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }


     public RegisterCertificate findCertificate(StoreAddressRequest request){

        //TODO изменю далее
        return null;

     }



}
