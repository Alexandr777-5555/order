package ru.register.shop.domain;


import javax.persistence.*;

@Table(name = "Address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address_street")
    private String street;

    @Column(name = "address_number")
    private String number;

    @ManyToOne(cascade = {CascadeType.REFRESH} , fetch =FetchType.LAZY )
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
