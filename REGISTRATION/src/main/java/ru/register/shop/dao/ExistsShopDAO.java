package ru.register.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.register.shop.domain.RegisterCertificate;

import java.util.List;

/**
 * существует ли такой магазин запрос в бд через JPA
 */
@Repository
public interface ExistsShopDAO extends JpaRepository<RegisterCertificate , Long> {


    /**
     * поиск сертификата по номеру
     * @param number
     * @return
     */
    List<RegisterCertificate> findByNumber(String number);


    /**
     *
     *  поиск подстроки в строке номера
     * @param number
     * @return
     */
    List<RegisterCertificate> findByNumberContaining(String number);



    List<RegisterCertificate> findByNum(@Param("number") String number);


}
