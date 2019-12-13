package area.validator.register;

import area.util.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class ProductRegisterRequest {


    private int product_id;
    private String title;
    private int productCount;
    private double price;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate date; // дата



    public ProductRegisterRequest() {

    }

    public ProductRegisterRequest(Product product) {

        product_id=product.getProduct_id();
        title=product.getTitle();
        productCount=product.getProductCount();
        price=product.getPrice();
        date=product.getDate();

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
}
