package ru.register.shop.business;


import ru.register.shop.dao.ExistsShopDAO;
import ru.register.shop.view.StoreAddressRequest;
import ru.register.shop.view.StoreAddressResponse;

public class ExistsManage {


     private ExistsShopDAO dao;



    /**
     *
     * найти что данный магазин существует
     *
     * @param request
     * @return
     */
    public StoreAddressResponse findRegisterShop(StoreAddressRequest request){

     // TODO пока не поддерживаем эту операцию
        throw new UnsupportedOperationException("не поддерживается");
    }



}
