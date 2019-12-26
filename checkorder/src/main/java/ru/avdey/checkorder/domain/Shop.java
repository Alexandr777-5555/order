package ru.avdey.checkorder.domain;


import javax.persistence.*;


@Table(name = "Shop")
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long shopID;

    @Column(name = "title")
    private String  name;

    @Column (name = "address")
    private String address;



    


}
