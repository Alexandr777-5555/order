package ru.avdey.domain;


/**
 *
 * ответ от склада stock
 *
 *
 *
 */
public class ProductResponse {

    private boolean exist; // продукт существует
    private int count; //количество продуктов на складе


    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "ProductResponse{" +
                "exist=" + exist +
                ", count=" + count +
                '}';
    }
}
