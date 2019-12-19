package ru.register.shop.domain;


import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("2")
public class BigShop extends Shop {

    @OneToMany(cascade = {CascadeType.REFRESH} , fetch = FetchType.LAZY, mappedBy = "shop")
  private List<RegisterCertificate> certificates;


    public List<RegisterCertificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<RegisterCertificate> certificates) {
        this.certificates = certificates;
    }
}
