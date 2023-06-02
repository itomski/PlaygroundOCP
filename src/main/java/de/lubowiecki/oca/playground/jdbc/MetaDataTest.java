package de.lubowiecki.oca.playground.jdbc;

import java.sql.*;

public class MetaDataTest {

    public static void main(String[] args) {

        try(Connection connection = DbConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()) {

            stmt.execute("SELECT id, firstname FROM users");
            ResultSet result = stmt.getResultSet();

            ResultSetMetaData meta = result.getMetaData();

            int numCol = meta.getColumnCount();
            System.out.println(meta.getTableName(1));
            for(int i = 1; i <= numCol; i++) {
                System.out.print(meta.getColumnName(i) + ", ");
                System.out.print(meta.getColumnTypeName(i));
                System.out.println();
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
