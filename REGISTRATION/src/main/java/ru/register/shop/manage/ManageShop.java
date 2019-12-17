package ru.register.shop.manage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.register.shop.domain.Shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class ManageShop {


    public static void main(String[] args) {


       exampleHibernate();

        exampleJPA();

    }

    private static void exampleJPA() {

        EntityManagerFactory  factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();

        Shop shop = new Shop();
        shop.setName("GAZ");

        entityManager.persist(shop);
        System.out.println(shop.getShoppingID());
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager=factory.createEntityManager();
        List fromShop = entityManager.createQuery("FROM Shop ").getResultList();
        fromShop.forEach(o -> System.out.println(o));
        entityManager.close();

    }

    private static void exampleHibernate() {
        SessionFactory sessionBuild = buildSessionFactory();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        Session session = sessionBuild.openSession();
        session.getTransaction().begin();
        session.getTransaction().commit();

        Shop shop = new Shop();
        shop.setName("Подкова");
        Long id = (Long) session.save(shop);

        System.out.println(id);
        session.close();

        session = sessionBuild.openSession();
        Shop shopName = session.get(Shop.class, id);
        System.out.println(shopName.toString());
        session.close();

        session = sessionBuild.openSession();
        List<Shop> list = session.createQuery("FROM Shop", Shop.class).list();
        session.close();
        list.forEach(shop1 -> System.out.println(shop1));
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
