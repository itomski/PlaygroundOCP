package de.lubowiecki.oca.playground.generics.orm;

public abstract class AbstractRepository<T extends AbstractEntity> implements Crud<T> {

    private final String TABLE;

    public AbstractRepository(String table) {
        this.TABLE = table;
    }

    // Hier kommen alle Methoden rein, die für alle Repositories gleich sind

    @Override
    public boolean deleteById(int id) {
        final String SQL = "DELETE FROM " + TABLE + " WHERE id = " + id;
        // TODO: SQL an die DB senden
        return false;
    }
}
