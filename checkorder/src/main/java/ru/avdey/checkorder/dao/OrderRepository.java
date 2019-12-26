package ru.avdey.checkorder.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.avdey.checkorder.domain.DocumentOrder;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<DocumentOrder, Long> {

    @Query("SELECT doc FROM DocumentOrder doc" +
          //  " WHERE doc.shop = :shop " +
            " WHERE doc.dateCreate= :dateCreate " +
            " AND doc.desc =:desc" )
    List<DocumentOrder> findDocumentOrders(
            @Param("dateCreate") LocalDate dateCreate ,
            @Param("desc") String desc
            );

}

