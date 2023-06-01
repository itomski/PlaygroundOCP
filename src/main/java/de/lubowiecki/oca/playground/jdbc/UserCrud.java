package de.lubowiecki.oca.playground.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCrud implements Crud<User> {

    @Override
    public List<User> findAll() throws SQLException {

        List<User> list = new ArrayList<>();

        // TODO: Zugangsdaten an eine zentralle Stelle auslagern
        final String url = "jdbc:mysql://localhost:8889/startdb";

        try(Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement stmt = connection.createStatement()) {

            ResultSet results = stmt.executeQuery("SELECT * FROM users");
            while(results.next()) {
                list.add(create(results));
            }
        }

        return list;
    }

    @Override
    public Optional<User> findById() throws SQLException {
        return Optional.empty();
    }

    @Override
    public User insert(User user) throws SQLException {
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public User create(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setBirthdate(rs.getDate("birthdate").toLocalDate());
        return user;
    }
}
