package ru.register.shop.view;

import java.io.Serializable;


public class StoreAddressResponse implements Serializable {

    private boolean exists;


    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
