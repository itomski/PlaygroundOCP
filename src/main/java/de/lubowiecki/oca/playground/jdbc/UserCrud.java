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

        /*
        final String sql = "INSERT INTO users (id, firstname, lastname, birthdate) " +
                "VALUES(null, '" + user.getFirstname() + "', '" + user.getLastname() + "', '" + user.getBirthdate() + "')";

        try(Connection connection = DbConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()) {

            stmt.execute(sql);
            boolean ok = stmt.getUpdateCount() > 0;
            return user;
        }
        */

        final String sql = "INSERT INTO users (id, firstname, lastname, birthdate) VALUES(null, ?, ?, ?)";

        try(Connection connection = DbConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Statement wird schon zur Vorbereitung an die DB übergeben
            // Statement.RETURN_GENERATED_KEYS = liefert vergebenen Primär-Schlüssel

            // Die Platzhalter werden mit konkreten Daten befüllt
            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setDate(3, Date.valueOf(user.getBirthdate()));
            stmt.execute();

            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                user.setId(keys.getInt(1));
            }
            return user;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {

        final String sql = "UPDATE users SET firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";

        try(Connection connection = DbConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) { // Statement wird schon zur Vorbereitung an die DB übergeben

            // Die Platzhalter werden mit konkreten Daten befüllt
            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setDate(3, Date.valueOf(user.getBirthdate()));
            stmt.setInt(4, user.getId());
            stmt.execute();

            return stmt.getUpdateCount() > 0;
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return delete("users", id);
    }

    @Override
    public User create(ResultSet rs) throws SQLException {

        // id | firstname | lastname | birthdate
        // 1  | Peter     | Parker   | 2000-10-15   <
        // 2  | Carol     | Danvers  | 1999-07-15

        // Cursor des ResultSets steht auf der aktuellen Zeile
        User user = new User();
        user.setId(rs.getInt("id"));
        // getInt liest den int-Wert aus einer Splate der aktuellen Zeile
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setBirthdate(rs.getDate("birthdate").toLocalDate());
        return user;
    }
}
