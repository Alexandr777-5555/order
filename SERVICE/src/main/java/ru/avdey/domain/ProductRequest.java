package ru.avdey.domain;


import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


/**
 *
 * запрос в БД STOCK
 *
 * TODO сделать что бы извне дату нельзя было изменить
 */

public class ProductRequest {


    // запрашиваем orderproduct.id_order
    // product.order_id и название продукта id_product (если этот id есть в stock) и количество product_count есть такое
    // в STOCK тогда

    /*
    private int idOrder; // orderproduct.id_order
    private int orderId; // product.order_id

     */

    // из stock

    private int product_id;  // id - ЭТО ВАЖЕН!!!
    private String title; // название продукта
    private int productCount; // количество
    private double price; // цена
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate date; // дата


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", productCount=" + productCount +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
