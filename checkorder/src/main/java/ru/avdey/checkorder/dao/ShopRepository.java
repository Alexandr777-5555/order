package ru.avdey.checkorder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.avdey.checkorder.domain.Shop;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {


    @Query("SELECT s FROM Shop s WHERE s.name = :name  " +
            " AND s.address = :address")
      List<Shop> findShop(
              @Param("name") String name ,
              @Param("address") String address
      );



}
