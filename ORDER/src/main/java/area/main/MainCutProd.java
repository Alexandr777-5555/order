package area.main;

import area.dao.RequestDao;
import area.domen.Shop;
import area.exception.DaoException;
import area.product.ProductCut;

import java.sql.SQLException;
import java.util.List;

public class MainCutProd {

    public static void main(String[] args) throws SQLException, DaoException {

        RequestDao requestDao=new RequestDao();

        List<Shop> shops=requestDao.findShop("ра");

        for (Shop shop: shops){
            System.out.println(shop);
        }
    }
}
