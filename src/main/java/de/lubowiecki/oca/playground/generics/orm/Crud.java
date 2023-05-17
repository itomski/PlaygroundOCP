package de.lubowiecki.oca.playground.generics.orm;

import java.util.List;
import java.util.Optional;

public interface Crud<T extends AbstractEntity> {

    /*
    List<T> find();

    Optional<T> find(int id);

    boolean insert(T obj);

    boolean update(T obj);
    */

    // das extends AbstractEntity garantiert, dass getId-Methode verfügbar ist
    default boolean delete(T obj) {
        return deleteById(obj.getId());
    }

    boolean deleteById(int id);

}
