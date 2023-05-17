package de.lubowiecki.oca.playground.generics.orm;

public abstract class AbstractEntity {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
