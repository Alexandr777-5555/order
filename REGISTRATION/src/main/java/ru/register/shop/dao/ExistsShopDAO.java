package ru.register.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.register.shop.domain.RegisterCertificate;

/**
 * существует ли такой магазин запрос в бд через JPA
 */
@Repository
public interface ExistsShopDAO extends JpaRepository<RegisterCertificate , Long> {






}
