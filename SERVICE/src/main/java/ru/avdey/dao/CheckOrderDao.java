package ru.avdey.dao;


import ru.avdey.config.Config;
import ru.avdey.domain.ProductRequest;
import ru.avdey.domain.ProductResponse;
import ru.avdey.exception.ProductCheckException;

import java.sql.*;

/**
 *
 * ПРОВЕРЯЕТ ФУНКЦИОНАЛЬНОСТЬ ЕСТЬ ЛИ ПРОДУКТЫ НА СКЛАДЕ
 */
public class CheckOrderDao {

    private ConnectionBuilder connectionBuilder;


    //запрос в базу stock
    private static final String SQL_REQUEST = " SELECT * FROM  stock st" +
            " INNER JOIN price_and_title_product patp on patp.product_id=st.product_id" +
            " WHERE " +
            "st.product_id=? and st.product_count>=? ";


    private static final String SQL_REQUEST_v2 = " SELECT * FROM  stock st" +
            " WHERE " +
            " st.product_id=? ";

    private static final String SQL_REQUEST_v3 = " SELECT * FROM  stock st" +
            " WHERE " +
            " st.product_id=? and st.product_count>=?";


    private static final String SQL_REQUEST_v4 = " SELECT * FROM  stock st WHERE st.title=?";


    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    /**
     * проверить если такой продукт у нас на складе
     *
     * @param request
     * @return
     */
    public ProductResponse checkProduct(ProductRequest request) throws ProductCheckException {

        ProductResponse response = new ProductResponse();


        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_REQUEST_v3)) {
            stmt.setInt(1, request.getProduct_id());
            stmt.setInt(2, request.getProductCount());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // если есть данные тогда
                System.out.println(rs.getInt(1));
                response.setExist(true); // такой продукт есть
                response.setCount(rs.getInt("product_count"));
                System.out.println("id продукта" + rs.getInt("product_id"));
            }

        } catch (SQLException ex) {

        }
        return response;
    }


    /**
     * проверить если такой продукт у нас на складе по имени
     *
     * @param request
     * @return
     */
    public ProductResponse checkProductForName(ProductRequest request) throws ProductCheckException {

        ProductResponse response = new ProductResponse();

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_REQUEST_v4)) {

            stmt.setString(1, request.getTitle());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {  // если есть данные тогда
                System.out.println("yes");
                response.setExist(true); // такой продукт есть
            }

        } catch (SQLException ex) {

        }
        return response;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
}

