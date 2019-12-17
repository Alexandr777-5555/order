package ru.register.shop.manage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.register.shop.domain.Shop;

import java.io.Serializable;

public class ManageShop {


    public static void main(String[] args) {


        SessionFactory sessionBuild = buildSessionFactory();

        Session session = sessionBuild.openSession();

        session.getTransaction().begin();

        session.getTransaction().commit();

        Shop shop = new Shop();

        shop.setName("Подкова");

        Long id = (Long) session.save(shop);

        System.out.println(id);

        session.close();


    }


    private static SessionFactory buildSessionFactory() {


        try {

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();


            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable throwable) {

            System.err.println("сессия не инициализирована" + throwable);
            throw new ExceptionInInitializerError(throwable);
        }
    }
}
