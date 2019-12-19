package ru.register.shop.dao;

import ru.register.shop.domain.Shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ShopDao {

    private EntityManager entityManager;

    public ShopDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }


    public List<Shop> findShops() {

        return  entityManager.createQuery("SELECT  s FROM Shop s").getResultList();

    }





}
