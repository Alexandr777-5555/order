package ru.register.shop.dao;

import ru.register.shop.domain.Shop;

import javax.persistence.*;
import java.util.List;

public class ShopDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Shop> findShops() {
        Query query = entityManager.createNamedQuery("Shop.findShops");
        //query.setParameter("shoppingid" , 2L);
        return query.getResultList();
    }


    public Long addShop(Shop shop) {

            entityManager.persist(shop);
            entityManager.flush();

        return shop.getShoppingID();
    }

}
