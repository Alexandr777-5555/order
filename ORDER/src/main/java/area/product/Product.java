package area.product;

public class Product {

    private final int number;
    private final int count;
    private final String title; // название продукта


    public Product(int number, int count , String title) {
        this.number = number;
        this.count = count;
        this.title = title;
    }


    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }


}
