package area.product;

public class ProductCut {


    private final int unique; // уникальный номер для каждого продукта
    private final String name;

    public ProductCut(int unique, String name) {
        this.unique = unique;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCut{" +
                "unique=" + unique +
                ", name='" + name + '\'' +
                '}';
    }
}
