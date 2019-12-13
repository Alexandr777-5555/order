package area.dao;

import area.exception.DaoException;
import area.order.Order;

import java.util.List;

/**
 *
 * заявка на продукты от магазина
 *
 */

public interface OrderForm {

    Long saveOrder(Order order) throws DaoException;

    /**
     * список заявок на продукты
     * @return
     * @throws DaoException
     */
    List<Order> getOrderList() throws  DaoException;
}
