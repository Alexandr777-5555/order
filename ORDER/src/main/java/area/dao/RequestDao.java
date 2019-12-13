package area.dao;

import area.config.Config;
import area.domen.Shop;
import area.exception.DaoException;
import area.product.ProductCut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * запрос к базе данных
 *
 *
 */

public class RequestDao implements Request {

    private static final Logger logger= LoggerFactory.getLogger(RequestDao.class);


    // ? - параметр
   private static final String GET_NAME_PROD="select namepr , unic from assortment where upper(namepr) like upper(?)";


   private static final String GET_NAME_ASSORTMENT="select namepr , unic from assortment where upper(namepr) like upper(?)";


   private static final String GET_NAME_SHOP="select id_shop , name_shop from shop where upper(name_shop) like upper(?)";




    public List<ProductCut> findProduct(String pattern) throws DaoException {

        List<ProductCut> products=new ArrayList<>();

        try (Connection connection=getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_NAME_ASSORTMENT);   // создаем соединение
        )  {
            statement.setString(1,"%" +  pattern + "%" );
            // resultSet - тут содержится наше множество  результатов
            ResultSet rs = statement.executeQuery();  // выполняем запрос
            while (rs.next()){
                products.add(new ProductCut( rs.getInt(2) , rs.getString(1)));
            }
        } catch (SQLException ex){
            logger.error(ex.getMessage() , ex);
            throw new DaoException(ex);
        }
        return products;
    }










    @Override
    public List<Shop> findShop(String pattern) throws DaoException {
        List<Shop> shops=new ArrayList<>();

        try (Connection connection=getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_NAME_SHOP);   // создаем соединение
        )  {
            statement.setString(1,"%" +  pattern + "%" );
            // resultSet - тут содержится наше множество  результатов
            ResultSet rs = statement.executeQuery();  // выполняем запрос
            while (rs.next()){
                shops.add(new Shop( rs.getInt(1) , rs.getString(2)));
            }
        } catch (SQLException ex){
            throw new DaoException(ex);
        }
        return shops;
    }


    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }


}
