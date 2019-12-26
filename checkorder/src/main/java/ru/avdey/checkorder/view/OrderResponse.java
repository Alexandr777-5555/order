package ru.avdey.checkorder.view;


import ru.avdey.checkorder.domain.Discount;
import ru.avdey.checkorder.domain.Product;
import ru.avdey.checkorder.domain.Shop;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class OrderResponse {

    private String desc;
    private LocalDate dateCreate;
    private String shopName;
    private String discount;


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
