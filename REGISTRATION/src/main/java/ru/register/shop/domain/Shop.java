package ru.register.shop.domain;


import java.time.LocalDate;
import java.util.List;

public class Shop {

    private Long shoppingID;
    private String name;
    private LocalDate dateCreate;
    private List<Address> addressList;
    private Inn inn;

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

    public Inn getInn() {
        return inn;
    }

    public void setInn(Inn inn) {
        this.inn = inn;
    }


}
