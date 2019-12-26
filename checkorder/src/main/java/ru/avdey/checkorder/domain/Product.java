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


    @ManyToOne(cascade = {CascadeType.REFRESH} , fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private DocumentOrder document;


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DocumentOrder getDocument() {
        return document;
    }

    public void setDocument(DocumentOrder document) {
        this.document = document;
    }
}
