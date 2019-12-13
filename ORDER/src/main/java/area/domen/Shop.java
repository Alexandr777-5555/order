package area.domen;

public class Shop {

  private int shopId;
  private String name;

    public Shop() {
    }

    public Shop(int shopId) {
        this.shopId = shopId;
    }

    public Shop(int shopId, String name) {
        this.shopId = shopId;
        this.name = name;
    }


    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                '}';
    }
}
