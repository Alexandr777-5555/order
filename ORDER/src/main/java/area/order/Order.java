package area.order;


import area.domen.OrderStatus;
import area.domen.Shop;
import area.product.Product;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * заявка на заказ
 */
public class Order {

    private Long id;
    private int product; // уникальный номер продукта
    private List<Product> productList;
    private Date date;
    private Shop shop;
    private LocalDateTime time;
    private OrderStatus orderStatus;
    private int amount; // количество

    public Order() {
    }

    public Order(int product, Shop shop, int amount) {
        this.product = product;
        this.shop = shop;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
