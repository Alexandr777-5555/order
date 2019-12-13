package area.dao;

import area.domen.Shop;
import area.exception.DaoException;
import area.product.ProductCut;

import java.util.List;


/***
 *
 *
 * это будет заявка из Shop в STORE
 */
public interface Request {


    public List<ProductCut> findProduct(String pattern) throws DaoException;

    public List<Shop> findShop(String pattern) throws DaoException;





}
