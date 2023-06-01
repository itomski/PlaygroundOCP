package de.lubowiecki.oca.playground.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest {

    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:8889/startdb";

        /*
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            // Abfrage
            connection.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        */

        try(Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement stmt = connection.createStatement()) {

            ResultSet results = stmt.executeQuery("SELECT * FROM users"); // Abfrage von Daten

            List<User> users = new ArrayList<>();

            while(results.next()) {
                users.add(create(results));
            }

            users.forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            /*
            StringBuilder sb = new StringBuilder();
            while(results.next()) {
                sb.append(results.getInt("id")).append(", ");
                sb.append(results.getString("firstname")).append(", ");
                sb.append(results.getString("lastname")).append(", ");
                sb.append(results.getDate("birthdate")).append("\n");
            }
            System.out.println(sb);
            */

            // connection wird automatisch geschlossen
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Programmende");
    }

    // ORM
    private static User create(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setBirthdate(rs.getDate("birthdate").toLocalDate());
        return user;
    }
}
