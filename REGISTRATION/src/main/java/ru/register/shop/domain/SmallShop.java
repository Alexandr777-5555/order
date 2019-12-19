package ru.register.shop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class SmallShop extends Shop {

    @OneToMany(cascade = {CascadeType.REFRESH} , fetch = FetchType.LAZY, mappedBy = "shop")
    private List<RegisterCertificate> certificates;


    public List<RegisterCertificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<RegisterCertificate> certificates) {
        this.certificates = certificates;
    }
}
