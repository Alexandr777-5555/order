package ru.avdey.checkorder.domain;


import javax.persistence.*;
import java.util.List;


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

    @OneToMany(cascade = {CascadeType.REFRESH} , fetch = FetchType.LAZY , mappedBy = "shop")
    private List<DocumentOrder> documents;


    public Long getShopID() {
        return shopID;
    }

    public void setShopID(Long shopID) {
        this.shopID = shopID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<DocumentOrder> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentOrder> documents) {
        this.documents = documents;
    }
}
