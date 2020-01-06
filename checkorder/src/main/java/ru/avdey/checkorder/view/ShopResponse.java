package ru.avdey.checkorder.view;


import ru.avdey.checkorder.domain.Discount;
import ru.avdey.checkorder.view.adapter.LocalDateAdapter;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class ShopResponse {

    private String desc;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateCreate;
    private Discount discount;


    @PostConstruct
    private void init(){

        if (desc==null){
            desc="empty";
        }
        if (dateCreate==null){
            dateCreate=LocalDate.parse("2001-01-01");
        }
        if(discount==null){
            discount=Discount.EMPTY;
        }
    }






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
