package area.validator;


import area.answers.AnswerStockStoreRegister;
import area.dao.OrderFormImpl;
import area.exception.DaoException;
import area.order.Order;

import java.util.List;

/**
 *
 * класс проверяет все заявки на заказ продуктов
 *
 */
public class OrderValidator {





    public OrderValidator() {


    }

    /**
     * проверяем все заявки на продукты
     *
     *
     */

    // TODO будем пробигаться по каждой заявке и и смотреть список продуктов если эти продукты есть в Assortiment тогда
    // TODO заявке  будем присваивать  статус 1
    public static void main(String[] args) {

        OrderValidator  ov=new OrderValidator();

        ov.checkAll();

    }



    public void checkAll(){
        try {
            List<Order> orders=readProductOrders();
            for (Order order : orders) {
                checkOneOrder(order);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }



    public void checkOneOrder(Order order) {
        AnswerStockStoreRegister cityAnswer = checkStoreStoke(order);
    }

    public AnswerStockStoreRegister checkStoreStoke(Order order) {


       // return registerChecker.checkProduct(order)
        return null;
    }





    public List<Order> readProductOrders() throws DaoException {

        return new OrderFormImpl().getOrderList();
    }




}
