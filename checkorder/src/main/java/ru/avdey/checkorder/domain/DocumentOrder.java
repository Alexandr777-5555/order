package ru.avdey.checkorder.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "Document")
@Entity
public class DocumentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderID;

    @Column(name = "desc")
    private String desc;

    @Column(name = "date")
    private LocalDate dateCreate;





}
