package ru.register.shop.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "reg_shop")
@Entity
public class Shop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long shoppingID;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "shop_date_create")
    private LocalDate dateCreate;

    @OneToMany(cascade ={CascadeType.REFRESH} , fetch = FetchType.LAZY , mappedBy = "shop")
    private List<Address> addressList;

    @Column(name = "shop_inn")
    private int inn;

    public Long getShoppingID() {
        return shoppingID;
    }

    public void setShoppingID(Long shoppingID) {
        this.shoppingID = shoppingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }


}
