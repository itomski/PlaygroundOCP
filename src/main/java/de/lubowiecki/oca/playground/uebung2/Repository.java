package de.lubowiecki.oca.playground.uebung2;

import java.time.LocalDate;
import java.util.List;

public interface Repository<T> {

    public List<T> fildAll();

    public T find(LocalDate date);

    public void add(T t);

}
