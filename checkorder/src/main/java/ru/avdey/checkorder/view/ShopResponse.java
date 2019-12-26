package ru.avdey.checkorder.view;


import ru.avdey.checkorder.domain.Discount;
import ru.avdey.checkorder.view.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class ShopResponse {

    private String desc;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateCreate;
    private Discount discount;


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

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
