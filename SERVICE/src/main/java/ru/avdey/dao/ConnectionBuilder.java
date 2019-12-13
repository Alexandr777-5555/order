package ru.avdey.dao;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * служит для соединения с БД
 */
public interface ConnectionBuilder {


    Connection getConnection() throws SQLException;


}
