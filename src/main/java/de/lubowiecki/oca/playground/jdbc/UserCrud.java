package de.lubowiecki.oca.playground.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCrud implements Crud<User> {

    @Override
    public List<User> findAll() throws SQLException {
        return findAll("users", null);
    }

    @Override
    public Optional<User> findById(int id) throws SQLException {
        return findAll("users", "WHERE id = " + id).stream().findFirst();
    }

    public List<User> findByBirthdate(LocalDate date) throws SQLException {
        return findAll("users", "WHERE birthdate = '" + date + "'");
    }

    // INSERT INTO users (id, firstname, lastname, birthdate) VALUES(null, 'Max', 'Mustermann', '2000-05-10');

    @Override
    public User insert(User user) throws SQLException {
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return delete("users", id);
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
