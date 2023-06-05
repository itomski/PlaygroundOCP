package de.lubowiecki.oca.playground.jdbc;

import java.sql.*;

public class CallableStatementTest {

    public static void main(String[] args) {

        try(Connection connection = DbConnectionFactory.getConnection();
            CallableStatement stmt = connection.prepareCall("{call selectAllUsers()}")) {

            stmt.execute();
            ResultSet results = stmt.getResultSet();

            while(results.next()) {
                System.out.println(results.getString(2) + " " + results.getString(3));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
