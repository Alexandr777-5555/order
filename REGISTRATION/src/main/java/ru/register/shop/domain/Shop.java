package ru.register.shop.domain;


import javax.persistence.*;

@Entity  // сущность которую надо сохранять
@Table(name = "shopping")  //  в какую таблицу сохранять
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_id")
    private Long shoppingID;

    @Column(name ="name")
    private String name;


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
}
