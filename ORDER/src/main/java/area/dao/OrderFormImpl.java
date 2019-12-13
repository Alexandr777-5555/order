package area.dao;

import area.domen.OrderStatus;
import area.domen.Shop;
import area.exception.DaoException;
import area.order.Order;
import area.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderFormImpl implements OrderForm {

    private static final Logger logger= LoggerFactory.getLogger(OrderFormImpl.class);

    private static final String INSERT_ORDER = "INSERT INTO orderproduct(" +
            "order_shop , order_date, order_time, order_status)" +
            "VALUES (?, ?, ?, ?);";


    private static final String INSERT_PRODUCTS = "INSERT INTO product(" +
            "order_id, id_product , product_count)" + "VALUES (?, ? , ?);";

     public static final String SELECT_ORDERS = "SELECT * FROM orderproduct";
  //   public static final String SELECT_ORDERS = "SELECT ord.* , prod.order_id  FROM orderproduct ord" +
  //           "INNER JOIN  product prod ON ord.id_order=prod.order_id";



    public static final String SELECT_ORDERS_PRODUCT = "SELECT ord.*, prod.* FROM orderproduct ord " +
            "INNER JOIN product prod ON ord.id_order=prod.order_id "+
            "WHERE order_id IN ";



    @Override
    public Long saveOrder(Order order) throws DaoException {


        logger.debug("order {}" , order);

        Long result = -1L;
        // создаем соединение
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ORDER, new String[]{"id_order"}))
        {
            //  Savepoint savepoint=connection.setSavepoint();
            try {
                //false озночает что сами управляем транзакцией
                connection.setAutoCommit(false);
                //  Savepoint savepoint=connection.setSavepoint();
                //1 order_shop
                Shop shop = order.getShop();
                statement.setInt(1, shop.getShopId());
                // 2 id_order
                // ВТОРОЙ НЕ БРАЛ ЭТО АВТО ПОДСТАНОВКА!!!
                // statement.setLong(2 ,   );
                //  statement.setLong(2 ,   result );
                //3  order_date
                //  java.sql.Date date=new Date().toLocalDate();
                //java.sql.Date.valueOf(order.getTime().toLocalDate())

                java.util.Date date=new java.util.Date();

                statement.setDate(2, new Date(date.getYear(), date.getMonth(), date.getDay()));
                //4 order_time
                // время
                statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                //5 order_status
                // статус
                statement.setInt(4, OrderStatus.START.ordinal());
                //6 order_product
             //   statement.setInt(5, order.getProduct());
                //7 product_count
              //  statement.setInt(6, order.getAmount());

                statement.executeUpdate();


                // возвращает список полей которые сгенерировали
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    result = generatedKeys.getLong(1);
                }
                generatedKeys.close();

                saveProductsForOrder(connection, order, result); // сохраняем продукты для заказа
                connection.commit(); // все хорошо


            } catch (SQLException ex) {

                if(connection!=null) {
                    connection.rollback();
                    System.out.println("я тут");
                }
                throw ex;

            }


        } catch (SQLException e) {
            // пишет полный стэк при таком формате
            logger.error(e.getMessage() , e);
           throw new DaoException(e);

        }
        return result;
    }


    @Override
    public List<Order> getOrderList() throws DaoException {
        List<Order> result =new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ORDERS))
        {
      //   statement.setInt(1 , OrderStatus.START.ordinal());

           ResultSet rs=statement.executeQuery();
          // List<Long> ids=new LinkedList<>();

           while (rs.next()){ // до тех пор пока есть следующий элемент
               Order order=new Order();
               fillOrder(rs , order);
               result.add(order);
           }

            findProducts(connection , result);

           rs.close();
        } catch (SQLException e) {
            logger.error(e.getMessage() , e);
        }
        return result;
    }


    private void findProducts(Connection connection, List<Order> result) throws SQLException {
        // stream() это как конвеер
        // хочу взять заявку (order) на продукты и получить из нее только ID в строку
        String string = "("+ result.stream().map(order -> String.valueOf(order.getProduct()))
                //собираем по разным принципам (стратегиям) в моем случае все просто собрать все строчки
                .collect(Collectors.joining(","))+")";


        // собрать наш result в MAP ассоциативный массив
        Map<Long, Order> map = result.stream().collect(Collectors
                // ключ это id заявки , а значение это сама и есть заявка
                .toMap(order -> order.getId(), order -> order));

        try(PreparedStatement stmt=connection.prepareStatement(SELECT_ORDERS_PRODUCT + string)) {
              ResultSet resultSet = stmt.executeQuery();
              while (resultSet.next()){
                  Product product = fillProduct(resultSet);
                System.out.println(product.getNumber());
                  Order order = map.get(resultSet.getInt("id_order"));
              }
          }
    }

    private Product fillProduct(ResultSet resultSet) throws SQLException {

        int id=resultSet.getInt("id_product");
        int count =resultSet.getInt("product_count");

        Product product=new Product(id , count , " " );

        return product;
    }

    private void fillOrder(ResultSet rs, Order order) throws SQLException {


        order.setId(rs.getLong(1));
        order.setDate(rs.getDate(4));
        order.setTime(rs.getTimestamp("order_time").toLocalDateTime());
        order.setOrderStatus(OrderStatus.fromValue(rs.getInt("order_status")));
        order.setProduct(rs.getInt("id_order"));



    }



    private void saveProductsForOrder(Connection connection, Order order, Long result) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCTS)) {
         //   int counter=0;
            for (Product product : order.getProductList()) {
                statement.setLong(1, result); // идентификатор заказа
                statement.setInt(2, product.getNumber());
                statement.setInt(3, product.getCount());
                statement.addBatch(); // пакетное исполнение
            //    counter++;
              //  if(counter>10000){
              //      statement.executeBatch();
              //      counter=0;
           //     }
            }
        //    if(counter>0)
            statement.executeBatch();
        }
    }

    private Connection getConnection() throws SQLException {

        return ConnectionBuilder.getConnection();
    }
}
