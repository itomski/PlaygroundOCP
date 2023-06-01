package de.lubowiecki.oca.playground.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Crud<T extends AbstractEntity> {

    List<T> findAll() throws SQLException;

    Optional<T> findById() throws SQLException;

    User insert(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;

    boolean deleteById(int id) throws SQLException;

    T create(ResultSet rs) throws SQLException;
}
