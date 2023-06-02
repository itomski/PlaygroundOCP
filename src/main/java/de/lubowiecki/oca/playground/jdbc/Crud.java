package de.lubowiecki.oca.playground.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Crud<T extends AbstractEntity> {

    List<T> findAll() throws SQLException;

    default List<T> findAll(final String table, final String ext) throws SQLException {

        List<T> list = new ArrayList<>();

        try(Connection connection = DbConnectionFactory.getConnection();
            //Statement stmt = connection.createStatement()
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            // ResultSet.TYPE_SCROLL_INSENSITIVE = wir können sich im ResultSet beliebig bewegen
            // ResultSet.CONCUR_UPDATABLE = Daten können geändert und erweitert werden - Änderungen werden in die DB geschreiben

            StringBuilder sb = new StringBuilder("SELECT * FROM ");

            if(table != null)
                sb.append(table);

            if(ext != null)
                sb.append(" ").append(ext);

            // ResultSet results = stmt.executeQuery(sb.toString()); // Liefert den ResultSet
            stmt.execute(sb.toString());
            ResultSet results = stmt.getResultSet();

            /*
            results.next(); // versetzt den Cursor auf die nähste Zeile
            // ResultSet muss scrollable sein
            results.absolute(10); // versetzt den Cursor auf die Zeile 10
            results.beforeFirst(); // versetzt den Cursor vor die erste Zeile
            results.afterLast(); // versetzt den Cursor hinter die letzte Zeile
            results.previous(); // versetzt den Cursor eine Zeile zurück
            results.relative(2); // Versetzt den Cursor zei Zeilen vorwärts
            */

            while(results.next()) {
                list.add(create(results));
            }
        }

        return list;
    }

    Optional<T> findById(int id) throws SQLException;

    User insert(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    default boolean delete(T t) throws SQLException {
        return deleteById(t.getId());
    }

    boolean deleteById(int id) throws SQLException;

    default boolean delete(final String table, final int id) throws SQLException {

        try(Connection connection = DbConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()) {

            StringBuilder sql = new StringBuilder("DELETE FROM ");

            if(table != null)
                sql.append(table);

            if(id > 0)
                sql.append(" WHERE id = ").append(id);

            // return stmt.executeUpdate(sql.toString()) > 0; // Liefert einen Updatecount

            stmt.execute(sql.toString());
            return  stmt.getUpdateCount() > 0;

        }
    }

    T create(ResultSet rs) throws SQLException;
}
