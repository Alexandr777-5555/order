package ru.avdey.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.avdey.web.CheckOrderServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder {

    private static final Logger LOGGER= LoggerFactory.getLogger(PoolConnectionBuilder.class);

    private DataSource dataSource; // пул соединений


    public PoolConnectionBuilder() {
        try {
            Context context=new InitialContext();
            dataSource=(DataSource) context.lookup("java:comp/env/jdbc/storeStock");

        }catch (NamingException e){
           LOGGER.error(" " , e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
