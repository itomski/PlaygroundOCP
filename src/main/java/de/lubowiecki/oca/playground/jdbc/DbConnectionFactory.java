package de.lubowiecki.oca.playground.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:8889/startdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DbConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
