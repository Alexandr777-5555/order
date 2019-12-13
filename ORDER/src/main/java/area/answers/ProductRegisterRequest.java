package area.answers;

import area.order.Order;
import area.product.Product;
import area.util.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 *
 *  запрос
 *
 */

public class ProductRegisterRequest {

    private int product_id;  // id - ЭТО ВАЖЕН!!!
    private String title; // название продукта
    private int productCount; // количество
  //  private double price; // цена
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate date; // дата

    public ProductRegisterRequest() {

    }

    public ProductRegisterRequest(Product product) {

        product_id=product.getNumber();
        productCount=product.getCount();
        title=product.getTitle();


    }


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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "ProductRegisterRequest{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", productCount=" + productCount +
                ", date=" + date +
                '}';
    }
}
