package ru.avdey.checkorder.domain;

import javax.persistence.*;


@Table(name = "Product")
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productID;

    @Column(name = "title")
    private String  name;

    @Column(name = "amount")
    private int amount;





}
