package ru.avdey.checkorder.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.avdey.checkorder.domain.DocumentOrder;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<DocumentOrder, Long> {

    @Query("SELECT doc FROM Document doc" +
          //  " WHERE doc.shop = :shop " +
            " WHERE doc.dateCreate= :date " +
            " AND doc.desc =: description" )
    List<DocumentOrder> findDocumentOrders(
            @Param("date") LocalDate dateCreate ,
            @Param("description") String desc
            );

}

