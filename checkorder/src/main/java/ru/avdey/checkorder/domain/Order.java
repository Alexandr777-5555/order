package ru.avdey.checkorder.domain;


import javax.persistence.*;

@Table(name = "Order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderID;






}
