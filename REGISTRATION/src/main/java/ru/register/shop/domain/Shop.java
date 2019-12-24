package ru.register.shop.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "reg_shop")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "uid", discriminatorType = DiscriminatorType.INTEGER)


@NamedQueries({
       @NamedQuery(name = "Shop.findShops" , query =
                "SELECT  s FROM Shop s"
               +" LEFT JOIN  FETCH s.addressList "
               +" LEFT JOIN  FETCH s.certificate "
           //  + "WHERE s.shoppingID = :shoppingid "
               )

})

public abstract class Shop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long shoppingID;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "shop_date_create")
    private LocalDate dateCreate;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "shop")
    private List<Address> addressList;

    @Column(name = "shop_inn")
    private int inn;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "shop")
    private RegisterCertificate certificate;


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

    public RegisterCertificate getCertificate() {
        return certificate;
    }

    public void setCertificate(RegisterCertificate certificate) {
        this.certificate = certificate;
    }
}
