package ru.avdey.checkorder.view;


import ru.avdey.checkorder.view.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class OrderRequest {

    private String shopName;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateCreate;

    private String desc;


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
